package com.example.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.dao.SearchMapper;
import com.example.feign.SearchFeign;
import com.example.pojo.Scenery;
import com.example.pojo.SceneryData;
import com.example.service.SceneryService;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class SceneryServiceImpl implements SceneryService {
    @Autowired
    private SearchMapper mapper;

    @Autowired
    private SearchFeign feign;

    @Autowired
    private ElasticsearchTemplate template;

    /**
     * 把数据库的数据导入到es
     *
     * @return
     */
    @Override
    public List<Scenery> exportAll() {
        List<SceneryData> list = feign.findAll();
        //将List<SceneryData>转成List<Scenery>
        List<Scenery> sceneryList = JSON.parseArray(JSON.toJSONString(list), Scenery.class);
        mapper.saveAll(sceneryList);
        return sceneryList;
    }

    //ik分词器 模糊查
    @Override
    public List<Scenery> FuzzyByName(Map<String, String> map) {
        List<Scenery> list = template.queryForList(buildBasicQuery(map).build(), Scenery.class);
        return list;
    }

    @Override
    public List<Scenery> FuzzyByKeyword(Map<String, String> map) {
        List<Scenery> sceneryList = template.queryForList(buildBasicFuzzyQuery(map).build(), Scenery.class);
        return sceneryList;
    }

    //构建查询条件/通过name字符串查,ik分词器
    public NativeSearchQueryBuilder buildBasicQuery(Map<String, String> searchMap) {
        //NativeSearchQueryBuilder:搜索条件构建对象,用于封装各种搜索条件
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        if (searchMap != null && searchMap.size() > 0) {
            //根据关键词搜索
            String keywords = searchMap.get("keyword");
            //如果关键词不为空，则搜索关键词数据
            if (!StringUtils.isEmpty(keywords)) {
                nativeSearchQueryBuilder.withQuery(QueryBuilders.queryStringQuery(keywords).field("categoryName"));
            }
        }
        return nativeSearchQueryBuilder;
    }

    //构建查询条件/通过name字符串查,ik_max_word分词器
    public NativeSearchQueryBuilder buildBasicFuzzyQuery(Map<String, String> searchMap) {
        //NativeSearchQueryBuilder:搜索条件构建对象,用于封装各种搜索条件
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        if (searchMap != null && searchMap.size() > 0) {
            //根据关键词搜索
            String keywords = searchMap.get("keyword");
            //如果关键词不为空，则搜索关键词数据
            if (!StringUtils.isEmpty(keywords)) {
                nativeSearchQueryBuilder.withQuery(QueryBuilders.queryStringQuery(keywords).field("name"));
            }
        }
        return nativeSearchQueryBuilder;
    }
}
