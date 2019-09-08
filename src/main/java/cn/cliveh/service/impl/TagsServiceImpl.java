package cn.cliveh.service.impl;

import cn.cliveh.dao.TagsDao;
import cn.cliveh.domain.Tags;
import cn.cliveh.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="http://cliveh.cn/"> CliveH </a>
 * @version 1.0
 * @date 2019/8/21
 */
@Service
public class TagsServiceImpl implements TagsService {

    @Autowired
    private TagsDao tagsDao;

    //@Cacheable(value = "common", key = "allTag")
    @Override
    public List<Tags> findAllTag() {
        return tagsDao.findAllTag();
    }

    @Override
    public Integer getTagCount() {
        return tagsDao.getTagCount();
    }

    //@Cacheable(value = "common", key = "articlesOnTag")
    @Override
    public List<Tags> findArticlesOnTag() {
        return tagsDao.findArticlesOnTag();
    }

    @Override
    public void updateTagSize(Integer tagId) {
        tagsDao.updateTagSize(tagId);
    }

    @Override
    public Integer saveTag(String tagName) {
        tagsDao.saveTag(tagName);
        return tagsDao.getTagMaxId();
    }
}
