package cn.com.webxml;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 *
 * This class was generated by Apache CXF 3.2.10
 * 2019-10-04T17:47:49.565+08:00
 * Generated source version: 3.2.10
 *
 */
@org.springframework.stereotype.Service
@WebServiceClient(name = "WeatherWS",
                  wsdlLocation = "file:/Users/hezq/MyBlog/src/main/resources/WeatherWS.wsdl",
                  targetNamespace = "http://WebXml.com.cn/")
public class WeatherWS extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://WebXml.com.cn/", "WeatherWS");
    public final static QName WeatherWSSoap12 = new QName("http://WebXml.com.cn/", "WeatherWSSoap12");
    public final static QName WeatherWSSoap = new QName("http://WebXml.com.cn/", "WeatherWSSoap");
    public final static QName WeatherWSHttpPost = new QName("http://WebXml.com.cn/", "WeatherWSHttpPost");
    public final static QName WeatherWSHttpGet = new QName("http://WebXml.com.cn/", "WeatherWSHttpGet");
    static {
        URL url = null;
        try {
            url = new URL("classpath:WeatherWS.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WeatherWS.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "classpath:WeatherWS.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WeatherWS(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WeatherWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WeatherWS() {
        super(WSDL_LOCATION, SERVICE);
    }

    public WeatherWS(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public WeatherWS(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public WeatherWS(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns WeatherWSSoap
     */
    @WebEndpoint(name = "WeatherWSSoap12")
    public WeatherWSSoap getWeatherWSSoap12() {
        return super.getPort(WeatherWSSoap12, WeatherWSSoap.class);
    }

    /**
     *
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherWSSoap
     */
    @WebEndpoint(name = "WeatherWSSoap12")
    public WeatherWSSoap getWeatherWSSoap12(WebServiceFeature... features) {
        return super.getPort(WeatherWSSoap12, WeatherWSSoap.class, features);
    }


    /**
     *
     * @return
     *     returns WeatherWSSoap
     */
    @WebEndpoint(name = "WeatherWSSoap")
    public WeatherWSSoap getWeatherWSSoap() {
        return super.getPort(WeatherWSSoap, WeatherWSSoap.class);
    }

    /**
     *
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherWSSoap
     */
    @WebEndpoint(name = "WeatherWSSoap")
    public WeatherWSSoap getWeatherWSSoap(WebServiceFeature... features) {
        return super.getPort(WeatherWSSoap, WeatherWSSoap.class, features);
    }


    /**
     *
     * @return
     *     returns WeatherWSHttpPost
     */
    @WebEndpoint(name = "WeatherWSHttpPost")
    public WeatherWSHttpPost getWeatherWSHttpPost() {
        return super.getPort(WeatherWSHttpPost, WeatherWSHttpPost.class);
    }

    /**
     *
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherWSHttpPost
     */
    @WebEndpoint(name = "WeatherWSHttpPost")
    public WeatherWSHttpPost getWeatherWSHttpPost(WebServiceFeature... features) {
        return super.getPort(WeatherWSHttpPost, WeatherWSHttpPost.class, features);
    }


    /**
     *
     * @return
     *     returns WeatherWSHttpGet
     */
    @WebEndpoint(name = "WeatherWSHttpGet")
    public WeatherWSHttpGet getWeatherWSHttpGet() {
        return super.getPort(WeatherWSHttpGet, WeatherWSHttpGet.class);
    }

    /**
     *
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WeatherWSHttpGet
     */
    @WebEndpoint(name = "WeatherWSHttpGet")
    public WeatherWSHttpGet getWeatherWSHttpGet(WebServiceFeature... features) {
        return super.getPort(WeatherWSHttpGet, WeatherWSHttpGet.class, features);
    }

}
