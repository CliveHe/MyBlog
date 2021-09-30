package cn.cliveh;

import cn.cliveh.dao.ArticleDao;
import cn.cliveh.dao.TagsDao;
import cn.cliveh.domain.Article;
import cn.cliveh.domain.Comment;
import cn.cliveh.domain.Tags;
import cn.cliveh.service.ArticleService;
import cn.cliveh.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 持久层测试
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.1
 * @date 2019/7/15
 */
/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ArticleTest {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private TagsDao tagsDao;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    //@Autowired
    //private RedisTemplate redisTemplate;

    @Test
    public void findAllArticle() {
        */
/*PageInfo<Article> allArticles = articleService.findAllArticleByPage(2);
        for (Article allArticle : allArticles) {
            System.out.println(allArticle);
        }*//*

        //PageInfo<Article> allArticle = articleService.findAllArticleByPage(3);
        //System.out.println(allArticle);
    }

    @Test
    public void findAllTag(){
        List<Tags> allTag = tagsDao.findAllTag();
        for (Tags tags : allTag) {
            System.out.println(tags);
        }
    }

    @Test
    public void findArticlesOnTag(){
        List<Tags> articlesOnTag = tagsDao.findArticlesOnTag();
        for (Tags article : articlesOnTag) {
            System.out.println(article);
        }
    }

    @Test
    public void findArticlesByDate(){
        Map<String, List<Article>> articlesByDate = articleService.findArticlesByDate();
        for (Map.Entry<String, List<Article>> entry : articlesByDate.entrySet()) {
            System.out.println("年："+entry.getKey()+"-----------");
            for (Article article : entry.getValue()) {
                System.out.println("文章："+article);
            }
        }
    }

    @Test
    public void findArticleById(){
        Article articleById = articleService.findArticleById(2);
        System.out.println(articleById);

    }

    @Test
    public void findArticleTitleById(){
        String articleById = articleService.findArticleTitleById(2);
        System.out.println(articleById);

    }

    @Test
    public void findCommentAndUser(){
        Comment commentAndUser = commentService.findCommentAndUser(2, 27);
        System.out.println(commentAndUser);
    }

    @Test
    public void findCommentByArticleId(){
        List<Comment> commentByArticleId = commentService.findCommentByArticleId(27);
        for (Comment comment : commentByArticleId) {
            System.out.println(comment);
        }
    }

    //@Test
    public void testRedis(){
        String views = articleService.updateRedisArticleViewsById(31);
        System.out.println(views);
    }

    @Test
    public void findAllArticleId(){
        List<Integer> allArticleId = articleService.findAllArticleId();
        for (Integer integer : allArticleId) {
            System.out.println(integer);
        }
    }

    //@Test
    public void updateArticleViews(){
        List<Integer> allArticleId = articleService.findAllArticleId();
        for (Integer articleId : allArticleId) {
            //将 Redis里的浏览量信息同步到数据库里
            Integer views = Integer.parseInt(articleService.getRedisArticleViewsById(articleId));
            articleService.updateArticleViews(articleId, views);
        }
    }


}
*/
