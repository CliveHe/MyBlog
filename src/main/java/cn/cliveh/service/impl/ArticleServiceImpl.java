package cn.cliveh.service.impl;

import cn.cliveh.dao.ArticleDao;
import cn.cliveh.domain.Article;
import cn.cliveh.domain.ArticleTags;
import cn.cliveh.service.ArticleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/20
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    /**
     * 每页显示文章条数
     */
    private final Integer PAGE_SIZE = 10;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Cacheable(value = "common", key = "'pageNo_'+#pageNo")
    @Override
    public PageInfo<Article> findAllArticleByPage(Integer pageNo) {

        //每页显示文章条数
        int pageSize = PAGE_SIZE;

        //分页查询，返回所有用户信息
        PageHelper.startPage(pageNo, pageSize);
        return new PageInfo<Article>(articleDao.findAllArticle());
    }

    @Cacheable(value = "common", key = "'archive'")
    @Override
    public Map<String, List<Article>> findArticlesByDate() {

        List<Article> articlesByDate = articleDao.findArticlesByDate();

        //根据 年 存放档案
        Map<String, List<Article>> archiveMap = new LinkedHashMap<String, List<Article>>();


        //裁取年和日期，封装
        for (Article article : articlesByDate) {
            String[] split = article.getPublishDate().split("-");
            article.setYear(split[0]);
            article.setDate(split[1] + "-" + split[2]);

        }

        //根据年 添加至map集合
        for (Article article : articlesByDate) {
            List<Article> articleList = new ArrayList<>();
            for (Article article1 : articlesByDate) {
                if (article.getYear().equals(article1.getYear())) {
                    //年 相同，则添加到同一个list集合
                    articleList.add(article1);
                }
            }

            //list去重
            List<Article> newList = articleList.stream().distinct().collect(Collectors.toList());
            //将list集合添加至map集合
            archiveMap.put(article.getYear(), newList);
        }

        return archiveMap;
    }

    @Cacheable(value = "common", key = "'id_'+#id")
    @Override
    public Article findArticleById(Integer id) {
        return articleDao.findArticleById(id);
    }

    @Override
    public Article findArticleAndMarkdownById(Integer id) {
        return articleDao.findArticleAndMarkdownById(id);
    }

    //@Cacheable(value = "common", key = "'ArticleTitle_aid_'+#id")
    @Override
    public String findArticleTitleById(Integer id) {
        return articleDao.findArticleTitleById(id);
    }

    //清除redisCache
    @CacheEvict(value = "common", allEntries = true)
    @Override
    public Integer saveArticle(Article article) {

        //保存当前文章
        articleDao.saveArticle(article);

        //返回本文章id
        return articleDao.getArticleMaxId();
    }

    @Override
    public Integer getArticleMaxId() {
        return articleDao.getArticleMaxId();
    }

    @Override
    public void updateArticleLastId(Article article) {
        articleDao.updateArticleLastId(article);
    }

    @Override
    public void updateArticleNextId(Article article) {
        articleDao.updateArticleNextId(article);
    }

    @Override
    public void saveArticleTags(ArticleTags articleTags) {
        articleDao.saveArticleTags(articleTags);
    }

    @CacheEvict(value = "common", allEntries = true)
    @Override
    public void deleteArticleById(Integer articleId) {

        //获取文章信息
        Article article = articleDao.findArticleById(articleId);

        //获取上一篇文章id
        int lastArticleId = article.getLastArticleId();

        //获取下一篇文章id
        int nextArticleId = article.getNextArticleId();

        //更新上一篇文章id的nextId为删除文章的下一篇文章id
        Article lastArticle = new Article();
        lastArticle.setId(lastArticleId);
        lastArticle.setNextArticleId(nextArticleId);
        articleDao.updateArticleNextId(lastArticle);

        //更新下一篇文章的lastId为删除文章的上一篇文章id
        Article nextArticle = new Article();
        nextArticle.setId(nextArticleId);
        nextArticle.setLastArticleId(lastArticleId);
        articleDao.updateArticleLastId(nextArticle);

        //删除外键
        articleDao.deleteArticleAndTagsByArticleId(articleId);
        //删除文章
        articleDao.deleteArticleById(articleId);
    }

    @Override
    public Integer getArticleTotalCount() {
        return articleDao.getArticleTotalCount();
    }

    @Override
    public List<Article> findRecentArticle() {
        return articleDao.findRecentArticle();
    }

    @CacheEvict(value = "common", allEntries = true)
    @Override
    public void updateArticle(Article article) {
        articleDao.updateArticle(article);
    }

    @Override
    public Integer updateArticleViewsById(Integer articleId) {
        articleDao.updateArticleViewsById(articleId);
        return articleDao.getArticleViewsById(articleId);
    }

    @Override
    public String updateRedisArticleViewsById(Integer articleId) {

        //文章点击量对应的key
        String key = "views_" + articleId;

        //如果Redis没有访问量数据
        if (redisTemplate.opsForValue().get(key) == null) {
            //从数据库获取文章的点击量views
            String views = articleDao.getArticleViewsById(articleId).toString();
            //保存到Redis
            redisTemplate.opsForValue().set(key, views);
        }

        //文章点击量加1
        redisTemplate.opsForValue().increment(key, 1);

        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    public String getRedisArticleViewsById(Integer articleId) {

        //文章点击量对应的key
        String key = "views_" + articleId;

        //如果Redis没有访问量数据
        if (redisTemplate.opsForValue().get(key) == null) {
            //从数据库获取文章的点击量views
            String views = articleDao.getArticleViewsById(articleId).toString();
            //保存到Redis
            redisTemplate.opsForValue().set(key, views);
        }

        return (String) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void updateArticleViews(Integer articleId, Integer views) {
        articleDao.updateArticleViews(articleId, views);
    }

    @Override
    public List<Integer> findAllArticleId() {
        return articleDao.findAllArticleId();
    }
}
