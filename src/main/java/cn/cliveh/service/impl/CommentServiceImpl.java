package cn.cliveh.service.impl;

import cn.cliveh.dao.CommentDao;
import cn.cliveh.domain.Comment;
import cn.cliveh.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/9/3
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public Integer saveComment(Comment comment) {

        //保存评论
        commentDao.saveComment(comment);
        //返回评论id
        return commentDao.getCommentMaxId();
    }

    @Override
    public List<Comment> findCommentByArticleId(Integer articleId) {
        return commentDao.findCommentByArticleId(articleId);
    }

    @Override
    public void saveUserComment(Integer uid, Integer cid) {
        commentDao.saveUserComment(uid, cid);
    }

    @Override
    public Comment findCommentAndUser(Integer commentId, Integer articleId) {
        return commentDao.findCommentAndUser(commentId, articleId);
    }

    @Override
    public Integer getCommentTotalCount() {
        return commentDao.getCommentTotalCount();
    }

    @Override
    public Integer getCommentCountByArticleId(Integer articleId) {
        return commentDao.getCommentCountByArticleId(articleId);
    }
}
