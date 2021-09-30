package cn.cliveh.service.impl;

import cn.cliveh.service.WeatherService;
import cn.cliveh.util.AddressUtil;
import cn.com.webxml.WeatherWS;
import cn.com.webxml.WeatherWSSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/10/5
 */
@Service
public class WeatherServiceImpl implements WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Autowired
    private WeatherWS weatherWS;

    @Override
    @Async  // 声明使用异步调用
    public void getWeather(HttpServletRequest request, HttpSession session) {

        log.debug("=======================开始异步调用天气服务=======================");

        //设置session存活时间
        session.setMaxInactiveInterval(60 * 60);
        //调用webservice天气服务
        WeatherWSSoap port = weatherWS.getPort(WeatherWSSoap.class);
        //地址
        String city = null;
        try {
            //获取地址
//            city = AddressUtil.getCity(request);
            log.debug("待查询天气地址：{}", city);
        } catch (Exception e) {
            e.printStackTrace();
            log.debug("获取地址出现异常：{}", e.toString());
        }

        //获取天气信息
        if (city != null && city.length() > 0) {
            List<String> weatherList = port.getWeather(city.replace("市", ""), null).getString();

            for (int i = 0; i < weatherList.size(); i++) {
                log.debug("\n第{}行：{}", i, weatherList.get(i));
            }

            if (weatherList.size() > 0) {
                String todayWeather = city +
                        "今日天气：" +
                        weatherList.get(weatherList.size() - 25).split(" ")[1] +
                        " " +
                        weatherList.get(weatherList.size() - 24);
                session.setAttribute("todayWeather", todayWeather);
                log.debug("{} 查询今天天气：{}", city, todayWeather);

                String tomorrowWeather = "明日天气：" +
                        weatherList.get(weatherList.size() - 20).split(" ")[1] +
                        " " +
                        weatherList.get(weatherList.size() - 19);
                session.setAttribute("tomorrowWeather", tomorrowWeather);
                log.debug("{} 查询明日天气：{}", city, todayWeather);
            }
        }

        log.debug("=======================结束异步调用天气服务=======================");

    }
}
