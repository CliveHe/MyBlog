package cn.cliveh.service;

import cn.cliveh.domain.Tags;

import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/21
 */
public interface TagsService {

    /**
     * 获取所有的文章标签
     *
     * @return
     */
    List<Tags> findAllTag();

    /**
     * 获取标签总数量
     *
     * @return
     */
    Integer getTagCount();

    /**
     * 获取某一个标签下的所有文章
     *
     * @return
     */
    List<Tags> findArticlesOnTag();

    /**
     * 更新tagSize
     * 用于插入一次数据tagSize就+1
     *
     * @param tagId
     */
    void updateTagSize(Integer tagId);

    /**
     * 保存新的标签
     * 返回tagId
     *
     * @param tagName 新的标签的名字
     * @return tagId
     */
    Integer saveTag(String tagName);

}
