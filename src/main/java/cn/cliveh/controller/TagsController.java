package cn.cliveh.controller;

import cn.cliveh.domain.Tags;
import cn.cliveh.service.TagsService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/21
 */
@Controller
public class TagsController {

    @Autowired
    private TagsService tagsService;

    @RequestMapping("/tags")
    public String findAllTag(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        //调用service的方法获取全部的标签
        List<Tags> allTag = tagsService.findAllTag();
        //调用service的方法获取标签总数量
        Integer tagCount = tagsService.getTagCount();
        //调用service的方法获取文章
        List<Tags> articlesOnTag = tagsService.findArticlesOnTag();

        if ("true".equals(request.getParameter("isJson"))) {
            //异步加载返回响应信息（模拟json字符串格式返回）
            String json = JSON.toJSONString(allTag);
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            out.write(json);
            out.flush();
            out.close();

            return null;
        } else {
            model.addAttribute("allTag", allTag);
            model.addAttribute("tagCount", tagCount);
            model.addAttribute("articlesOnTag", articlesOnTag);
        }


        return "tags";
    }

}
