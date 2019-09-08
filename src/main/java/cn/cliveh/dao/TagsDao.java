package cn.cliveh.dao;

import cn.cliveh.domain.Tags;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/2
 */
@Repository
public interface TagsDao {

    /**
     * 获取所有的标签
     *
     * @return 全部的标签
     */
    List<Tags> findAllTag();

    /**
     * 获取标签数量
     *
     * @return 标签数量
     */
    Integer getTagCount();

    /**
     * 获取某一个标签下的所有文章
     *
     * @return 某一个标签下的所有文章的列表
     */
    List<Tags> findArticlesOnTag();

    /**
     * 用于插入一次数据tagSize就+1
     *
     * @param tagId
     */
    void updateTagSize(Integer tagId);

    /**
     * 保存新的标签
     *
     * @param tagName
     */
    void saveTag(String tagName);

    /**
     * 获取执行时数据库中标签的最大id
     *
     * @return
     */
    Integer getTagMaxId();

}
