package cn.cliveh.service;

import cn.cliveh.domain.Comment;

import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/9/3
 */
public interface CommentService {

    /**
     * 保存评论
     *
     * @param comment 评论
     * @return 评论id
     */
    Integer saveComment(Comment comment);

    /**
     * 根据文章id查找评论
     *
     * @param articleId 文章id
     * @return 评论内容
     */
    List<Comment> findCommentByArticleId(Integer articleId);

    /**
     * 保存用户评论外键约束
     * @param uid
     * @param cid
     */
    void saveUserComment(Integer uid, Integer cid);

    /**
     * 查询评论及其用户信息
     * @param commentId
     * @param articleId
     * @return
     */
    Comment findCommentAndUser(Integer commentId, Integer articleId);

    /**
     * 获取数据库中评论总数
     * @return
     */
    Integer getCommentTotalCount();


    /**
     * 根据文章id获取数据库中评论总数
     * @return
     */
    Integer getCommentCountByArticleId(Integer articleId);
}
