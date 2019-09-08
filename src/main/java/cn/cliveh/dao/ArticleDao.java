package cn.cliveh.dao;

import cn.cliveh.domain.Article;
import cn.cliveh.domain.ArticleTags;
import cn.cliveh.domain.Tags;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/2
 * 文章Dao接口
 */
@Repository
public interface ArticleDao {

    /**
     * 分页查询全部的文章
     *
     * @return 全部的文章
     */
    List<Article> findAllArticle();

    /**
     * 根据日期归档文章
     *
     * @return
     */
    List<Article> findArticlesByDate();

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
     * 通过id获取文章标题
     *
     * @param id
     * @return
     */
    String findArticleTitleById(Integer id);

    /**
     * 保存文章
     *
     * @param article
     */
    void saveArticle(Article article);

    /**
     * 保存文章标签
     *
     * @param articleTags 文章id,标签id
     */
    void saveArticleTags(ArticleTags articleTags);

    /**
     * 获取执行时数据库中的最大的文章id
     *
     * @return
     */
    Integer getArticleMaxId();

    /**
     * 更新文章的上一篇的id
     *
     * @param article
     */
    void updateArticleLastId(Article article);

    /**
     * 更新文章的下一篇的id
     *
     * @param article
     */
    void updateArticleNextId(Article article);

    /**
     * 按id删除文章
     * 注意：先删除外键约束
     *
     * @param articleId
     */
    void deleteArticleById(Integer articleId);

    /**
     * 通过文章id删除对应的外键约束
     *
     * @param articleId
     */
    void deleteArticleAndTagsByArticleId(Integer articleId);

    /**
     * 获取文章总篇数
     *
     * @return 文章总篇数
     */
    Integer getArticleTotalCount();

    /**
     * 最近的文章
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
     * 文章浏览量+1
     *
     * @param articleId
     */
    void updateArticleViewsById(Integer articleId);

    /**
     * 根据文章id获取文章浏览量
     *
     * @param articleId
     * @return
     */
    Integer getArticleViewsById(Integer articleId);

    /**
     * 更新文章浏览量
     *
     * @param articleId
     * @param views
     */
    void updateArticleViews(@Param("articleId") Integer articleId, @Param("pageview") Integer views);

    /**
     * 获取所有文章的id
     * @return
     */
    List<Integer> findAllArticleId();

}
