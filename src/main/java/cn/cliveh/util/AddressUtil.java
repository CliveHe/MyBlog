package cn.cliveh.util;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import cn.cliveh.task.InitWeatherLocationId;
import org.springframework.http.HttpRequest;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.2
 * @date 2019/9/2
 */
public class AddressUtil {

    private static final Logger log = LoggerFactory.getLogger(AddressUtil.class);
    private static final String KEY = "APGBZ-ZV7KQ-7AQ52-GMUD7-55H5Q-UOFCJ";
    private static final String API_PREFIX = "https://apis.map.qq.com/ws/location/v1/ip?ip=";
    private static final Integer OK_STATUS = 0;

    /**
     * 获取真实地址
     *
     * @param request
     * @return
     */
    public static String getAddress(HttpServletRequest request) {

        // 根据IP获取地址json字符串
        String urlData = getPositionByRequest(request);

        JSONObject data = JSONObject.parseObject(urlData);
        if (OK_STATUS.equals(data.get("status"))) {
            JSONObject addressJson = data.getJSONObject("result").getJSONObject("ad_info");
            String province = addressJson.get("province").toString();
            String city = addressJson.get("city").toString();
            log.info("查询的IP的地址为：{}", province + " " + city);
            return "IP地址：" + province + " " + city;
        }

        return "IP地址未知";
    }

    /**
     * 获取城市
     *
     * @param request
     * @return
     */
    public static String getCity(HttpServletRequest request) {

        // 根据IP获取地址json字符串
        String urlData = getPositionByRequest(request);

        JSONObject data = JSONObject.parseObject(urlData);
        if (OK_STATUS.equals(data.get("status"))) {
            JSONObject addressJson = data.getJSONObject("result").getJSONObject("ad_info");
            String city = addressJson.get("city").toString();
            log.info("查询的IP的城市为：{}", city);
            return city;
        }

        return "未知";
    }

    public static String getLocationId(HttpServletRequest request) {
        // 根据IP获取地址json字符串
        String urlData = getPositionByRequest(request);

        JSONObject data = JSONObject.parseObject(urlData);
        if (OK_STATUS.equals(data.get("status"))) {
            JSONObject addressJson = data.getJSONObject("result").getJSONObject("ad_info");
            String province = addressJson.get("province").toString();
            String city = addressJson.get("city").toString();
            String district = addressJson.get("district").toString();
            log.info("查询的IP的地址为：{}", province + ":" + city + ":" + district);
            Map<String, String> locationIdMap = InitWeatherLocationId.getLocationIdMap();
            if (!locationIdMap.isEmpty()) {
                if (district!=null && district.length() > 0) {
                    city = district;
                }
                return locationIdMap.get(province + city.substring(0, city.length() - 1));
            } else {
                InitWeatherLocationId.initLocationId();
                if (district!=null && district.length() > 0) {
                    city = district;
                }
                return locationIdMap.get(province + city.substring(0, city.length() - 1));
            }
        }
        return "未知";
    }

    /**
     * //响应示例：
     * {
     * "status": 0,
     * "message": "query ok",
     * "result": {
     * "ip": "111.206.145.41",
     * "location": {
     * "lat": 39.90469,
     * "lng": 116.40717
     * },
     * "ad_info": {
     * "nation": "中国",
     * "province": "北京市",
     * "city": "北京市",
     * "district": "",
     * "adcode": 110000
     * }
     * }
     * }
     */

    private static String getPositionByRequest(HttpServletRequest request) {

        log.debug("=======================开始调用腾讯位置服务接口=======================");
        //腾讯位置服务接口
        //设置IP方便本地测试
        HttpURLConnection connection = null;
        BufferedReader bReader = null;
        StringBuilder stringBuilder = null;
        String ip = null;
        try {
            ip = ("127.0.0.1".equals(IPUtil.getIpAddress(request))
                    || "0:0:0:0:0:0:0:1".equals(IPUtil.getIpAddress(request))) ? "47.107.101.22" : IPUtil.getIpAddress(request);
            if (ip != null) {
                String api = API_PREFIX + ip + "&key=" + KEY;

                // 1.获取url
                URL url = new URL(api);
                // 2.获取HttpURLConnection对象
                connection = (HttpURLConnection) url.openConnection();
                // 3.调用connect方法连接远程资源
                connection.connect();
                // 4.访问资源数据，使用getInputStream方法获取一个输入流用以读取信息
                bReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
                // 对数据进行访问
                String line = null;
                stringBuilder = new StringBuilder();
                while ((line = bReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            } else {
                log.error("获取的IP信息为空");
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("获取位置信息失败： {}", e.getMessage());
        } finally {
            if (bReader != null) {
                // 关闭流
                try {
                    bReader.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                    log.error("关闭流失败： {}", exception.getMessage());
                }
            }
            if (connection != null) {
                // 关闭链接
                connection.disconnect();
            }
        }

        //json字符串
        assert stringBuilder != null;
        String urlData = stringBuilder.toString().replaceAll(" ", "");
        log.info("\n查询IP：{}, 腾讯位置服务接口返回Data: {}", ip, urlData);
        log.debug("=======================结束调用腾讯位置服务接口=======================");

        return urlData;

    }

}
