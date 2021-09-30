package cn.cliveh.util;

import com.alibaba.druid.util.DruidWebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/9/2
 */
public class IPUtil {

    private static final Logger log = LoggerFactory.getLogger(IPUtil.class);

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String getIpAddress(HttpServletRequest request) throws IOException {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址
        log.debug("=======================开始获取IP=======================");

        String remoteAddr = DruidWebUtils.getRemoteAddr(request);
        log.debug("Druid连接池Utils中获取的ip: {} ", remoteAddr);

        String ip = request.getHeader("x-forwarded-for");
        log.debug("X-Forwarded-For中获取的ip: {} ", ip);
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                log.debug("Proxy-Client-IP中获取的ip: {}", ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                log.debug("WL-Proxy-Client-IP中获取的ip: {}", ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                log.debug("HTTP_CLIENT_IP中获取的ip: {}", ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                log.debug("HTTP_X_FORWARDED_FOR中获取的ip: {}", ip);
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                log.debug("request.RemoteAddr中获取的ip: {}", ip);
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (String strIp : ips) {
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    log.debug("X-Forwarded-For中截取的ip{}: ", ip);
                    break;
                }
            }
        }

        log.debug("最终获取的ip: {}", ip);
        log.debug("=======================IP获取结束=======================");

        return ip;
    }

}
