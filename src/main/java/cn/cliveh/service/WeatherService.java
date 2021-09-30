package cn.cliveh.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/10/5
 */
public interface WeatherService {

    /**
     * 获取天气信息
     * @param request
     * @param session
     */
    void getWeather(HttpServletRequest request, HttpSession session);

}
