package cn.cliveh.controller;

import cn.cliveh.domain.Comment;
import cn.cliveh.domain.User;
import cn.cliveh.service.CommentService;
import cn.cliveh.service.UserService;
import cn.cliveh.util.AddressUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/9/3
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @RequestMapping("/saveComment")
    public void saveComment(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String articleId = request.getParameter("articleId");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String link = request.getParameter("link");
        String commentContent = request.getParameter("commentContent");

        //校验用户是否已存在
        User commentUser = userService.findCommentUser(username, email);
        Integer userId = -1;
        //如果不存在
        if (commentUser == null) {
            //添加评论用户
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setWebsiteUrl(link);
            user.setAddress(AddressUtil.getAddress(request));
            //0为普通用户
            user.setRole(0);
            user.setRegisterTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            //返回用户id
            userId = userService.saveCommentUser(user);
        }else {
            userId = commentUser.getId();
        }

        //添加评论
        Comment comment = new Comment();
        comment.setParentId(0);
        comment.setArticleId(Integer.parseInt(articleId));
        comment.setAnswererId(userId);
        comment.setRespondentId(-1);
        comment.setCommentDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        comment.setCommentContent(commentContent);

        //保存评论，并返回评论id
        Integer commentId = commentService.saveComment(comment);

        //保存用户评论外键约束
        commentService.saveUserComment(userId, commentId);

        //根据评论id和页面id获取当前页面的评论和用户信息
        Comment commentAndUser = commentService.findCommentAndUser(commentId, Integer.parseInt(articleId));

        //异步加载返回响应信息（模拟json字符串格式返回）
        String json = JSON.toJSONString(commentAndUser);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write(json);
        out.flush();
        out.close();

    }

}
