package cn.cliveh.service;

import cn.cliveh.domain.Article;
import cn.cliveh.domain.ArticleTags;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/20
 */
public interface ArticleService {

    /**
     * 获取全部的文章
     *
     * @param pageNo 分页起始页
     * @return 文章
     */
    PageInfo<Article> findAllArticleByPage(Integer pageNo);

    /**
     * 根据日期归档文章
     *
     * @return date, url, title
     */
    Map<String, List<Article>> findArticlesByDate();

    /**
     * 根据id查询文章
     *
     * @param id
     * @return
     */
    Article findArticleById(Integer id);

    /**
     * 根据id查询文章，包含markdown
     *
     * @param id
     * @return
     */
    Article findArticleAndMarkdownById(Integer id);

    /**
     * 根据id获取文章标题
     *
     * @param id
     * @return
     */
    String findArticleTitleById(Integer id);

    /**
     * 保存文章
     *
     * @param article
     * @return
     */
    Integer saveArticle(Article article);

    /**
     * 获取执行时数据库中的最大的文章id
     *
     * @return
     */
    Integer getArticleMaxId();

    /**
     * 更新文章的上一篇的文章id
     *
     * @param article
     */
    void updateArticleLastId(Article article);

    /**
     * 更新文章的下一篇的文章id
     *
     * @param article
     */
    void updateArticleNextId(Article article);

    /**
     * 保存文章的标签
     *
     * @param articleTags
     */
    void saveArticleTags(ArticleTags articleTags);

    /**
     * 通过id删除文章
     *
     * @param articleId
     */
    void deleteArticleById(Integer articleId);

    /**
     * 获取文章总篇数
     *
     * @return 文章总篇数
     */
    Integer getArticleTotalCount();

    /**
     * 查询最近的10篇文章
     *
     * @return
     */
    List<Article> findRecentArticle();

    /**
     * 更新文章
     *
     * @param article
     */
    void updateArticle(Article article);

    /**
     * 文章浏览量+1，并且返回文章浏览量
     *
     * @param articleId
     * @return 文章浏览量
     */
    Integer updateArticleViewsById(Integer articleId);

    /**
     * Redis中文章浏览量+1，并且返回文章浏览量
     *
     * @param articleId
     * @return 文章浏览量
     */
    String updateRedisArticleViewsById(Integer articleId);

    /**
     * 获取Redis里保存的文章浏览量
     * @param articleId
     * @return
     */
    String getRedisArticleViewsById(Integer articleId);

    /**
     * 更新文章浏览量
     *
     * @param articleId
     * @param views
     */
    void updateArticleViews(Integer articleId, Integer views);

    /**
     * 获取所有文章的id
     *
     * @return
     */
    List<Integer> findAllArticleId();

}
