package cn.cliveh.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/2
 * 文章实体类
 */
public class Article implements Serializable {

    /**
     * 文章id，主键，自增
     */
    private int id;

    /**
     * 标题
     */
    private String articleTitle;

    /**
     * 文章摘要
     */
    private String articleAbstract;

    /**
     * 文章作者
     */
    private String articleAuthor;

    /**
     * 文章头图
     */
    private String articleImageUrl;

    /**
     * 文章内容
     */
    private  String articleContent;

    /**
     * 文章Markdown
     */
    private  String markdown;

    /**
     * 发布日期
     */
    private String publishDate;

    /**
     * 文章浏览量
     */
    private Integer pageview;

    /**
     * 上一篇文章id
     */
    private int lastArticleId;

    /**
     * 下一篇文章id
     */
    private int nextArticleId;

    /**
     * 文章标签
     */
    private List<Tags> tags;

    /**
     * 归档年
     */
    private String year;

    /**
     * 归档日期
     */
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAbstract() {
        return articleAbstract;
    }

    public void setArticleAbstract(String articleAbstract) {
        this.articleAbstract = articleAbstract;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleImageUrl() {
        return articleImageUrl;
    }

    public void setArticleImageUrl(String articleImageUrl) {
        this.articleImageUrl = articleImageUrl;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public String getMarkdown() {
        return markdown;
    }

    public void setMarkdown(String markdown) {
        this.markdown = markdown;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getPageview() {
        return pageview;
    }

    public void setPageview(Integer pageview) {
        this.pageview = pageview;
    }

    public int getLastArticleId() {
        return lastArticleId;
    }

    public void setLastArticleId(int lastArticleId) {
        this.lastArticleId = lastArticleId;
    }

    public int getNextArticleId() {
        return nextArticleId;
    }

    public void setNextArticleId(int nextArticleId) {
        this.nextArticleId = nextArticleId;
    }

    public List<Tags> getTags() {
        return tags;
    }

    public void setTags(List<Tags> tags) {
        this.tags = tags;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleAbstract='" + articleAbstract + '\'' +
                ", articleAuthor='" + articleAuthor + '\'' +
                ", articleImageUrl='" + articleImageUrl + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", markdown='" + markdown + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", pageview=" + pageview +
                ", lastArticleId=" + lastArticleId +
                ", nextArticleId=" + nextArticleId +
                ", tags=" + tags +
                ", year='" + year + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Article)) {
            return false;
        }
        Article article = (Article) o;
        return id == article.id &&
                lastArticleId == article.lastArticleId &&
                nextArticleId == article.nextArticleId &&
                Objects.equals(articleTitle, article.articleTitle) &&
                Objects.equals(articleAbstract, article.articleAbstract) &&
                Objects.equals(articleAuthor, article.articleAuthor) &&
                Objects.equals(articleImageUrl, article.articleImageUrl) &&
                Objects.equals(articleContent, article.articleContent) &&
                Objects.equals(markdown, article.markdown) &&
                Objects.equals(publishDate, article.publishDate) &&
                Objects.equals(pageview, article.pageview) &&
                Objects.equals(tags, article.tags) &&
                Objects.equals(year, article.year) &&
                Objects.equals(date, article.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, articleTitle, articleAbstract, articleAuthor, articleImageUrl, articleContent, markdown, publishDate, pageview, lastArticleId, nextArticleId, tags, year, date);
    }
}
