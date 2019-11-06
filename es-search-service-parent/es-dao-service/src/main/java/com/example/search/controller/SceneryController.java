package com.example.search.controller;

import com.example.pojo.SceneryData;
import com.example.search.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SceneryController {
    @Autowired
    private SceneryService service;

    //获取数据库中的全部数据
    @GetMapping("/all")
    public List<SceneryData> findAll(){
        List<SceneryData> list = service.findAll();
        return list;
    }

    //数据库导入到es
    @GetMapping("/goto")
    public String exportToEs(){
        return "ok";
    }
}
