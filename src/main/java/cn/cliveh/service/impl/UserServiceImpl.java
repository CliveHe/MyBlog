package cn.cliveh.service.impl;

import cn.cliveh.dao.UserDao;
import cn.cliveh.domain.User;
import cn.cliveh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(String username, String password) {

        return userDao.findUser(username, password);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public Integer saveCommentUser(User user) {

        //保存评论用户
        userDao.saveCommentUser(user);
        //返回用户id
        return userDao.getUserMaxId();
    }

    @Override
    public User findCommentUser(String username, String email) {
        return userDao.findCommentUser(username, email);
    }
}
