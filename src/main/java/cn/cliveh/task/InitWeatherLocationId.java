package cn.cliveh.task;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author hezq
 */
@Component
public class InitWeatherLocationId {

    /**
     * LocationId map集合
     */
    public static Map<String, String> LocationIdMap = new HashMap<>();

    @PostConstruct
    public static void initLocationId() {
        try {
            //获取文件绝对路径
            String classesPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("")).getPath();

            //读取文件
            //创建输入缓冲流对象
            BufferedReader br = new BufferedReader(new FileReader(classesPath + "Location_ID.txt"));

            //将文件的每一行数据添加到list中
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\t");
                LocationIdMap.put(split[0] + split[1], split[2]);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public static Map<String, String> getLocationIdMap() {
        return LocationIdMap;
    }

}
