package cn.cliveh.service;

import cn.cliveh.domain.User;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/26
 */
public interface UserService {

    /**
     * 登录校验
     *
     * @param username
     * @param password
     * @return
     */
    User findUser(String username, String password);

    /**
     * 根据id更新用户
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 创建评论用户
     *
     * @param user
     * @return
     */
    Integer saveCommentUser(User user);

    /**
     * 查询用户表中是否存在对应的评论用户
     *
     * @param username
     * @param email
     * @return
     */
    User findCommentUser(String username, String email);

}
