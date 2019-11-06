package com.example.service;

import com.example.pojo.Scenery;

import java.util.List;
import java.util.Map;

public interface SceneryService {
    List<Scenery> exportAll();

    List<Scenery> FuzzyByName(Map<String,String> map);

    List<Scenery> FuzzyByKeyword(Map<String,String> map);
}
