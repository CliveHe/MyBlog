package cn.cliveh.controller;

import cn.cliveh.domain.Article;
import cn.cliveh.domain.ArticleTags;
import cn.cliveh.service.ArticleService;
import cn.cliveh.service.CommentService;
import cn.cliveh.service.TagsService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/31
 */
@Controller
public class AdminController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagsService tagsService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/main")
    public String findMain(Model model) {

        //获取数据库中文章总篇数
        Integer articleTotalCount = articleService.getArticleTotalCount();

        //获取数据库中评论总数
        Integer commentTotalCount = commentService.getCommentTotalCount();

        model.addAttribute("articleTotalCount", articleTotalCount);
        model.addAttribute("commentTotalCount", commentTotalCount);

        return "main";
    }

    @RequestMapping("/manageArticle")
    public String findAllArticle(Model model, @RequestParam(defaultValue = "1", required = true, value = "pageNo") Integer pageNo, HttpServletRequest request) {

        if (pageNo < 1) {
            pageNo = 1;
        }
        //调用dao获取数据库中文章总篇数
        int articleTotalCount = articleService.getArticleTotalCount();
        //分页页面数量
        int totalPage = (articleTotalCount % 10) == 0 ? (articleTotalCount / 10) : (articleTotalCount / 10 + 1);
        if (pageNo > totalPage) {
            pageNo = totalPage;
        }

        //调用service的分页方法获取文章分页信息
        PageInfo<Article> pageInfo = articleService.findAllArticleByPage(pageNo);

        model.addAttribute("totalPage", totalPage);
        //model.addAttribute("currentPage", pageNo);
        request.getSession().setAttribute("currentPage", pageNo);
        model.addAttribute("pageInfo", pageInfo);
        return "manage-article";
    }

    @RequestMapping("/findArticleAndMarkdownById")
    public String findArticleById(Model model, @Param("articleId") Integer articleId) {

        Article article = articleService.findArticleAndMarkdownById(articleId);

        model.addAttribute("article", article);

        return "update-article";
    }

    @RequestMapping("/updateArticle")
    public String addArticle(@Param("articleId") Integer articleId, HttpServletRequest request) {

        //获取文章信息
        String articleTitle = request.getParameter("articleTitle");
        String articleAbstract = request.getParameter("articleAbstract");
        String articleAuthor = request.getParameter("articleAuthor");
        String articleImageUrl = request.getParameter("articleImageUrl");
        String articleContent = request.getParameter("my-editormd-html-code");
        String markdown = request.getParameter("my-editormd-markdown-doc");
        String publishDate = request.getParameter("publishDate");

        //封装数据
        Article updateArticle = new Article();
        updateArticle.setId(articleId);
        updateArticle.setArticleTitle(articleTitle);
        updateArticle.setArticleAbstract(articleAbstract);
        updateArticle.setArticleAuthor(articleAuthor);
        updateArticle.setArticleImageUrl(articleImageUrl);
        updateArticle.setArticleContent(articleContent);
        updateArticle.setMarkdown(markdown);
        updateArticle.setPublishDate(publishDate);

        //更新文章之前先保存文章所有浏览记录，因为更新文章会清除Redis的全部缓存
        List<Integer> allArticleId = articleService.findAllArticleId();
        for (Integer id : allArticleId) {
            //将 Redis里的浏览量信息同步到数据库里
            Integer views = Integer.parseInt(articleService.getRedisArticleViewsById(id));
            articleService.updateArticleViews(id, views);
        }

        //更新文章
        articleService.updateArticle(updateArticle);

        //获取新的标签
        String newTags = request.getParameter("newTags");
        List<Integer> tagIdsList = new ArrayList<>();

        if (!"".equals(newTags) && !" ".contains(newTags)) {
            if (newTags.contains(",")) {
                String[] newTagArr = newTags.split(",");
                for (String newTag : newTagArr) {
                    //保存新的标签到标签数据库
                    Integer newTagId = tagsService.saveTag(newTag);
                    tagIdsList.add(newTagId);
                }
            } else {
                //保存新的标签到标签数据库
                Integer newTagId = tagsService.saveTag(newTags);
                tagIdsList.add(newTagId);
            }
        }


        //保存标签
        for (Integer tagId : tagIdsList) {
            ArticleTags articleTags = new ArticleTags();
            articleTags.setAid(articleId);
            articleTags.setTid(tagId);
            articleService.saveArticleTags(articleTags);
            //文章标签保存成功，对应的tagSize就+1
            tagsService.updateTagSize(tagId);
        }


        //转发到article
        return "forward:/article?articleId=" + articleId;
    }

    /**
     * 根据id删除文章
     *
     * @param id 要删除的文章id
     * @return
     */
    @RequestMapping("/deleteArticle")
    public String deleteArticleById(@Param("id") String id, HttpServletRequest request) {

        //删除文章之前先保存所有文章浏览记录，因为删除文章会清除Redis的全部缓存
        List<Integer> allArticleId = articleService.findAllArticleId();
        for (Integer articleId : allArticleId) {
            //将 Redis里的浏览量信息同步到数据库里
            Integer views = Integer.parseInt(articleService.getRedisArticleViewsById(articleId));
            articleService.updateArticleViews(articleId, views);
        }

        //currentPage为删除操作所在页面的页码
        String currentPage = request.getSession().getAttribute("currentPage").toString();
        int pageNo = Integer.parseInt(currentPage);

        //获取数据库中文章总篇数
        int articleTotalCount = articleService.getArticleTotalCount();
        //分页页面数量
        int totalPage = (articleTotalCount % 10) == 0 ? (articleTotalCount / 10) : (articleTotalCount / 10 + 1);

        if (pageNo > totalPage) {
            pageNo = --pageNo;
        }

        //如果含有&就是批量删除
        if (id.contains("&")) {
            String[] idArr = id.split("&");
            for (String s : idArr) {
                articleService.deleteArticleById(Integer.parseInt(s));
            }

        } else {
            //删除单篇文章
            articleService.deleteArticleById(Integer.parseInt(id));
        }

        //跳转页面
        return "redirect:/manageArticle?pageNo=" + pageNo;
    }

}
