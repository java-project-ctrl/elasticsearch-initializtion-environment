package com.example.search.service.impl;

import com.example.pojo.SceneryData;
import com.example.search.dao.SceneryMapper;
import com.example.search.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SceneryServiceImpl implements SceneryService {
    @Autowired
    private SceneryMapper mapper;
    @Override
    public List<SceneryData> findAll() {
        List<SceneryData> list = mapper.selectAll();
        return list;
    }
}
