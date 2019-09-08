package cn.cliveh.domain;

import java.io.Serializable;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/23
 */
public class ArticleTags implements Serializable {

    /**
     * 文章id
     */
    private int aid;

    /**
     * 标签id
     */
    private int tid;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }
}
