package com.example.dao;

import com.example.pojo.Scenery;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import java.util.List;

public interface SearchMapper extends ElasticsearchCrudRepository<Scenery,Long> { }
