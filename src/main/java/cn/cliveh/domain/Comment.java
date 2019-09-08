package cn.cliveh.domain;

import java.io.Serializable;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/2
 * 评论实体类
 */
public class Comment implements Serializable {

    /**
     * 评论id
     */
    private Integer id;

    /**
     * 父Id
     */
    private Integer parentId;

    /**
     * 文章Id
     */
    private Integer articleId;

    /**
     * 评论者Id
     */
    private Integer answererId;

    /**
     * 被评论者Id
     */
    private Integer respondentId;

    /**
     * 评论日期
     */
    private String commentDate;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 评论点赞数
     */
    private Integer likes;

    /**
     * 是否已读
     */
    private Integer isRead;

    /**
     * 评论的用户信息
     */
    private User user;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getAnswererId() {
        return answererId;
    }

    public void setAnswererId(Integer answererId) {
        this.answererId = answererId;
    }

    public Integer getRespondentId() {
        return respondentId;
    }

    public void setRespondentId(Integer respondentId) {
        this.respondentId = respondentId;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "parentId=" + parentId +
                ", articleId=" + articleId +
                ", answererId=" + answererId +
                ", respondentId=" + respondentId +
                ", commentDate='" + commentDate + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", likes=" + likes +
                ", isRead=" + isRead +
                ", user=" + user +
                '}';
    }
}
