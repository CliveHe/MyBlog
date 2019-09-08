package cn.cliveh.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/9/2
 */
public class AddressUtil {

    /**
     * 获取真实地址
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static String getAddress(HttpServletRequest request) throws Exception {

        //腾讯位置服务接口
        //设置IP方便本地测试
        String ip = ("127.0.0.1".equals(IPUtil.getIpAddress(request)) || "0:0:0:0:0:0:0:1".equals(IPUtil.getIpAddress(request))) ? "123.207.61.7" : IPUtil.getIpAddress(request);
        String key = "APGBZ-ZV7KQ-7AQ52-GMUD7-55H5Q-UOFCJ";
        String api = "https://apis.map.qq.com/ws/location/v1/ip?ip=" + ip + "&key=" + key;

        // 1.获取url
        URL url = new URL(api);
        // 2.获取HttpURLConnection对象
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // 3.调用connect方法连接远程资源
        connection.connect();
        // 4.访问资源数据，使用getInputStream方法获取一个输入流用以读取信息
        BufferedReader bReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        // 对数据进行访问
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = bReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        // 关闭流
        bReader.close();
        // 关闭链接
        connection.disconnect();

        //json字符串
        String UrlData = stringBuilder.toString().replaceAll(" ", "");
        System.out.println("urlData" + UrlData);

        JSONObject addressJson = JSONObject.parseObject(UrlData).getJSONObject("result").getJSONObject("ad_info");
        String province = addressJson.get("province").toString();
        String city = addressJson.get("city").toString();

        return "IP地址：" + province + " " + city;
    }

}
