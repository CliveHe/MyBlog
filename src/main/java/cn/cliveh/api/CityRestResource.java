package cn.cliveh.api;

import cn.cliveh.util.AddressUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hezq
 */
@Controller
public class CityRestResource {

    @GetMapping("/locationId")
    @ResponseBody
    public String getLocationId(HttpServletRequest request) {
        return AddressUtil.getLocationId(request);
    }

}
