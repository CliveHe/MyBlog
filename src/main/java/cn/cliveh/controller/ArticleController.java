package cn.cliveh.controller;

import cn.cliveh.domain.Article;
import cn.cliveh.domain.ArticleTags;
import cn.cliveh.domain.Comment;
import cn.cliveh.service.ArticleService;
import cn.cliveh.service.CommentService;
import cn.cliveh.service.TagsService;
import cn.cliveh.service.WeatherService;
import cn.cliveh.util.AddressUtil;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/20
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagsService tagsService;

    @Autowired
    private CommentService commentService;

//    @Autowired
//    private WeatherService weatherService;

    /**
     * @param model
     * @param pageNo
     * @return
     */
    @RequestMapping("/home")
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

        //session存放天气信息
//        HttpSession session = request.getSession(true);
//        if (session.getAttribute("todayWeather") == null || session.getAttribute("tomorrowWeather") == null) {
//
//            //异步调用天气服务
//            weatherService.getWeather(request, session);
//
//        }

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageInfo", pageInfo);
        return "home";
    }

    /**
     * 查询最近的10篇文章
     * 查询about文章
     *
     * @param model
     * @return
     */
    @RequestMapping("/about")
    public String findRecentArticle(Model model) {

        //获取最近的10篇文章
        List<Article> recentArticle = articleService.findRecentArticle();
        model.addAttribute("recentArticle", recentArticle);

        return "about";
    }

    /**
     * @param model
     * @return
     */
    @RequestMapping("/archive")
    public String findArticlesByDate(Model model) {

        //调用service的方法获取根据日期归档的文章信息
        Map<String, List<Article>> articlesByDate = articleService.findArticlesByDate();

        //获取最近的10篇文章
        List<Article> recentArticle = articleService.findRecentArticle();

        model.addAttribute("articlesMap", articlesByDate);
        model.addAttribute("recentArticle", recentArticle);

        return "archive";
    }

    /**
     * 通过id查询文章
     *
     * @param model
     * @param articleId 文章id
     * @return
     */
    @RequestMapping("/article")
    public String findArticleById(Model model, @Param("articleId") Integer articleId) {

        Article articleById = articleService.findArticleById(articleId);
        String lastArticleTitle = null;
        String nextArticleTitle = null;

        try {
            //获取上一篇文章和下一篇文章的title，注意文章为倒序显示
            lastArticleTitle = articleService.findArticleTitleById(articleById.getLastArticleId()) == null ? "没有下一篇文章" : articleService.findArticleTitleById(articleById.getLastArticleId());
            nextArticleTitle = articleService.findArticleTitleById(articleById.getNextArticleId()) == null ? "没有上一篇文章" : articleService.findArticleTitleById(articleById.getNextArticleId());
        } catch (Exception e) {
            e.printStackTrace();
            return "404";
        }

        //获取评论
        List<Comment> comments = commentService.findCommentByArticleId(articleId);
        //获取数据库中评论总数
        Integer commentCount = commentService.getCommentCountByArticleId(articleId);

        //文章浏览量+1，返回文章浏览量
        String views = articleService.updateRedisArticleViewsById(articleId);

        model.addAttribute("lastArticleTitle", lastArticleTitle);
        model.addAttribute("nextArticleTitle", nextArticleTitle);
        model.addAttribute("article", articleById);
        model.addAttribute("comments", comments);
        model.addAttribute("commentCount", commentCount);
        model.addAttribute("views", views);
        return "article";
    }

    @RequestMapping("/addArticle")
    public String addArticle(HttpServletRequest request) {
        //获取文章信息
        String articleTitle = request.getParameter("articleTitle");
        String articleAbstract = request.getParameter("articleAbstract");
        String articleAuthor = request.getParameter("articleAuthor");
        String articleImageUrl = request.getParameter("articleImageUrl");
        if ("".equals(articleImageUrl)) {
            //如果没有设置文章头图，则使用默认图片
            articleImageUrl = "img/article_header/article_bg.jpg";
        }
        String articleContent = request.getParameter("my-editormd-html-code");
        String markdown = request.getParameter("my-editormd-markdown-doc");
        String publishDate = request.getParameter("publishDate");
        if ("".equals(publishDate)) {
            //生成发布日期
            publishDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        }
        int pageview = 0;

        //封装数据
        Article article = new Article();
        article.setArticleTitle(articleTitle);
        article.setArticleAbstract(articleAbstract);
        article.setArticleAuthor(articleAuthor);
        article.setArticleImageUrl(articleImageUrl);
        article.setArticleContent(articleContent);
        article.setMarkdown(markdown);
        article.setPublishDate(publishDate);
        article.setPageview(pageview);
        //设置当前文章的上一篇文章lastArticleId，如果上一篇没有文章，设为-1
        article.setLastArticleId(articleService.getArticleMaxId() == null ? -1 : articleService.getArticleMaxId());
        //下一篇没有文章，设为-1
        article.setNextArticleId(-1);


        Article lastArticle = new Article();
        //获取上一篇文章的id
        Integer lastId;
        //如果没有上一篇文章
        if (articleService.getArticleMaxId() == null) {
            lastId = -1;
        } else {
            lastId = articleService.getArticleMaxId();
        }
        lastArticle.setId(lastId);

        //调用service的保存文章方法，返回当前保存文章的id
        Integer currentId = articleService.saveArticle(article);

        //当前文章id为上一篇文章的NextId
        lastArticle.setNextArticleId(currentId);
        //更新上一篇文章的NextArticleId成功
        articleService.updateArticleNextId(lastArticle);


        //获取已有标签里选择的标签id
        String[] tagIds = request.getParameterValues("tags");
        List<String> tagIdsList;
        if (tagIds != null) {
            tagIdsList = new ArrayList<>(Arrays.asList(tagIds));
        } else {
            tagIdsList = new ArrayList<>();
        }

        //获取新的标签
        String newTags = request.getParameter("newTags");
        if (!"".equals(newTags) && !", ".contains(newTags)) {
            if (newTags.contains(",")) {
                String[] newTagArr = newTags.split(",");
                for (String newTag : newTagArr) {
                    //保存新的标签到标签数据库
                    Integer newTagId = tagsService.saveTag(newTag);
                    tagIdsList.add(String.valueOf(newTagId));
                }
            } else {
                //保存新的标签到标签数据库
                Integer newTagId = tagsService.saveTag(newTags);
                tagIdsList.add(String.valueOf(newTagId));
            }
        }


        //保存标签
        for (String tagId : tagIdsList) {
            ArticleTags articleTags = new ArticleTags();
            articleTags.setAid(currentId);
            articleTags.setTid(Integer.parseInt(tagId));
            articleService.saveArticleTags(articleTags);
            //文章标签保存成功，对应的tagSize就+1
            tagsService.updateTagSize(Integer.parseInt(tagId));
        }


        //转发到article
        return "forward:/article?articleId=" + currentId;
    }

    /**
     * 异步加载上一篇和下一篇文章title
     *
     * @param response
     * @param articleId
     * @throws Exception
     */
    @RequestMapping("/findTitle")
    public void findArticleTitleById(HttpServletResponse response, @Param("articleId") Integer articleId) throws Exception {
        //异步加载返回响应信息（模拟json字符串格式返回）
        PrintWriter out = response.getWriter();
        out.write(articleService.findArticleTitleById(articleId));
        out.flush();
        out.close();
    }

}
