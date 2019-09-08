package cn.cliveh.task;

import cn.cliveh.service.ArticleService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import java.util.List;

/**
 * Spring 整合 Quartz
 * 将 Redis里的浏览量信息同步到数据库里
 *
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/9/6
 */
@Component
public class SaveViewsJob implements Job {

    @Autowired
    private ArticleService articleService;

    //private Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        // 使得job对象可以通过注解实现依赖注入
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

        List<Integer> allArticleId = articleService.findAllArticleId();
        for (Integer articleId : allArticleId) {
            //将 Redis里的浏览量信息同步到数据库里
            Integer views = Integer.parseInt(articleService.getRedisArticleViewsById(articleId));
            articleService.updateArticleViews(articleId, views);
        }

        //log.info("文章浏览量 持久化成功！ - " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "\n");

    }
}
