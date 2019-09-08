package cn.cliveh.controller;

import cn.cliveh.domain.User;
import cn.cliveh.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/27
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/updateUser")
    public String updateUser(User user, @Param("oldPassword") String oldPassword, HttpServletRequest request) {

        //如果旧密码输入正确
        if (userService.findUser(user.getUsername(), oldPassword) != null) {
            User adminUser = (User) request.getSession(false).getAttribute("adminUser");
            user.setId(adminUser.getId());
            //修改用户信息
            userService.updateUser(user);
        }

        return "main";
    }

}
