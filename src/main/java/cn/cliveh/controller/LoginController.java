package cn.cliveh.controller;

import cn.cliveh.domain.User;
import cn.cliveh.service.UserService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Random;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/26
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getBingImgUrl")
    public void getBingImgUrl(HttpServletResponse response) throws Exception {

        //必应每日一图json接口
        URL url = new URL("https://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1");
        // 2.获取HttpURRLConnection对象
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
        String UrlData = stringBuilder.toString();

        JSONObject bingPicJson = JSONArray.parseObject(UrlData).getJSONArray("images").getJSONObject(0);
        String imgUrl = "https://cn.bing.com" + bingPicJson.get("url").toString();

        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(imgUrl);
        out.flush();
        out.close();
    }

    @RequestMapping("/outLogin")
    public String outLogin(HttpServletRequest request) {
        //删除登录信息
        request.getSession(false).removeAttribute("adminUser");
        return "redirect:home";
    }

    /**
     * 登录验证
     *
     * @param request    请求
     * @param username   管理员用户
     * @param password   密码
     * @param verifycode 验证码
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String loginAdmin(HttpServletRequest request, @Param("username") String username, @Param("password") String password, @Param("verifycode") String verifycode, Model model) {
        //调用service方法，同时将密码加密
        User adminUser = userService.findUser(username, DigestUtils.md5DigestAsHex(password.getBytes()));
        //获取session里的验证码
        HttpSession session = request.getSession();
        String checkCodeService = (String) session.getAttribute("checkCodeService");
        //确保验证码的一次性
        session.removeAttribute("checkCodeService");

        //校验验证码，忽略大小写比较
        try {
            if (!checkCodeService.equalsIgnoreCase(verifycode)) {
                //验证码错误
                //提示信息并跳转登录页面
                model.addAttribute("login_msg", "您输入的验证码错误！");

                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //判断是否登录成功
        if (adminUser != null) {
            if (adminUser.getRole() == 1) {
                //将用户存入session
                session.setAttribute("adminUser", adminUser);
                //跳转页面
                return "redirect:main";
            } else {
                //提示登录错误信息
                model.addAttribute("loginError", "权限不足！");
                return "login";
            }
        } else {
            //提示登录错误信息
            model.addAttribute("loginError", "账号或密码错误！");
            return "login";
        }

    }

    /**
     * 用于产生验证码
     *
     * @param request  请求
     * @param response 响应
     * @throws Exception 异常
     */
    @RequestMapping("/checkCode")
    public void checkCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //服务器通知浏览器不要缓存
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setHeader("expires", "0");

        //在内存中创建一个长80，宽30的图片，默认黑色背景
        //参数一：长
        //参数二：宽
        //参数三：颜色
        int width = 80;
        int height = 30;
        //创建BufferedImage对象，在内存中图片（验证码图片对象）
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //获取画笔
        Graphics g = image.getGraphics();
        //设置画笔颜色为灰色
        g.setColor(Color.GRAY);
        //填充图片
        g.fillRect(0, 0, width, height);

        //产生4个随机验证码，12Ey
        String checkCode = getCheckCode();
        //将验证码放入HttpSession中
        request.getSession().setAttribute("checkCodeService", checkCode);

        //设置画笔颜色为黄色
        g.setColor(Color.YELLOW);
        //设置字体的小大
        g.setFont(new Font("黑体", Font.BOLD, 24));
        //向图片上写验证码
        g.drawString(checkCode, 15, 25);

        //画干扰线
        g.setColor(Color.YELLOW);
        //随机生成干扰线的坐标点
        Random r = new Random();
        //画6条线
        for (int i = 0; i < 6; i++) {
            int x1 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int x2 = r.nextInt(width);
            int y2 = r.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }

        //将内存中的图片输出到浏览器
        //参数一：图片对象
        //参数二：图片的格式，如PNG,JPG,GIF
        //参数三：图片输出到哪里去
        ImageIO.write(image, "PNG", response.getOutputStream());
    }

    /**
     * 产生4位随机字符串
     *
     * @return 验证码
     */
    private String getCheckCode() {
        String base = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int size = base.length();
        //生成随机角标
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            //产生0到size-1的随机值
            int index = r.nextInt(size);
            //在base字符串中获取下标为index的字符
            char c = base.charAt(index);
            //将c放入到StringBuffer中去
            sb.append(c);
        }
        return sb.toString();
    }

}
