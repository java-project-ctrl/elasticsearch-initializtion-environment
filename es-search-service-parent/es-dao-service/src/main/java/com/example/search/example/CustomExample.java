package com.example.search.example;

import com.example.pojo.SceneryData;
import tk.mybatis.mapper.entity.Example;

public class CustomExample {
    public static Example getExample(SceneryData scenery) {
        Example example = new Example(SceneryData.class);
        Example.Criteria criteria = example.createCriteria();

        //模糊查询
        if (scenery.getName() != "") {
            criteria.andLike("name", "%" + scenery.getName() + "%");
        }
        return example;
    }
}
