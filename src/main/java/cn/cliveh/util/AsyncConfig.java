package cn.cliveh.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/10/5
 */
@Configuration
@EnableAsync
public class AsyncConfig implements AsyncConfigurer {

    /**
     * 定义线程池
     */
    @Override
    public Executor getAsyncExecutor() {
        // 定义线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        // 设置核心线程
        taskExecutor.setCorePoolSize(10);
        // 设置最大线程
        taskExecutor.setMaxPoolSize(30);
        // 设置线程队列最大线程数
        taskExecutor.setQueueCapacity(2000);
        // 初始化
        taskExecutor.initialize();

        return taskExecutor;
    }

}
