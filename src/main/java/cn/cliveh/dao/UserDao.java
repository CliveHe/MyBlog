package cn.cliveh.dao;

import cn.cliveh.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/2
 */
@Repository
public interface UserDao {

    /**
     * 校验用户，用于登录操作
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    User findUser(@Param("username") String username, @Param("password") String password);

    /**
     * 更新用户信息
     *
     * @param user
     */
    void updateUser(User user);

    /**
     * 创建评论用户
     *
     * @param user
     */
    void saveCommentUser(User user);

    /**
     * 获取执行时数据库中的最大的用户id
     *
     * @return
     */
    Integer getUserMaxId();

    /**
     * 查询用户表中是否存在对应的评论用户
     *
     * @param username
     * @param email
     * @return
     */
    User findCommentUser(@Param("username") String username, @Param("email") String email);

}
