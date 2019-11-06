package com.example.controller;

import com.example.pojo.Scenery;
import com.example.service.SceneryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SearchController {
    @Autowired
    private SceneryService service;

    @GetMapping("/list")
    public List<Scenery> exportAll() {
        List<Scenery> list = service.exportAll();
        return list;
    }

    @GetMapping("/find")
    public List<Scenery> findByKeyword(@RequestParam Map<String,String> map){
        List<Scenery> sceneryList = service.FuzzyByKeyword(map);
        return sceneryList;
    }

    @GetMapping("/fuzzy")
    public Object singleUserId(@RequestParam Map<String,String> map) {
        List<Scenery> list = service.FuzzyByName(map);
        return list;
    }


}
