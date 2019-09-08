package cn.cliveh.dao;

import cn.cliveh.domain.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/2
 */
@Repository
public interface CommentDao {

    /**
     * 保存评论
     *
     * @param comment
     */
    void saveComment(Comment comment);

    /**
     * 根据文章id查找文章里面评论
     *
     * @param articleId
     * @return
     */
    List<Comment> findCommentByArticleId(Integer articleId);

    /**
     * 获取执行时数据库中的最大的评论id
     *
     * @return
     */
    Integer getCommentMaxId();

    /**
     * 保存用户评论外键约束
     *
     * @param uid 用户id
     * @param cid 评论id
     */
    void saveUserComment(@Param("uid") Integer uid, @Param("cid") Integer cid);

    /**
     * 查询评论及其用户信息
     * @param commentId
     * @param articleId
     * @return
     */
    Comment findCommentAndUser(@Param("id") Integer commentId, @Param("articleId") Integer articleId);

    /**
     * 获取数据库中评论总数
     * @return
     */
    Integer getCommentTotalCount();

    /**
     * 根据文章id获取数据库中评论数
     * @param articleId
     * @return
     */
    Integer getCommentCountByArticleId(Integer articleId);

}
