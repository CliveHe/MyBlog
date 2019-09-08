package cn.cliveh.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/2
 * 标签实体类
 */
public class Tags implements Serializable {

    /**
     * 标签id
     */
    private Integer tagId;

    /**
     * 标签名称
     */
    private String tagName;

    /**
     * 标签数量
     */
    private Integer tagSize;

    private List<Article> articles;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagSize() {
        return tagSize;
    }

    public void setTagSize(Integer tagSize) {
        this.tagSize = tagSize;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Tags{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", tagSize=" + tagSize +
                ", articles=" + articles +
                '}';
    }
}
