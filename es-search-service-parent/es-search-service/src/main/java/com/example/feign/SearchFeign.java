package com.example.feign;

import com.example.pojo.SceneryData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "scenery-server")
public interface SearchFeign {
    @GetMapping("/all")
    List<SceneryData> findAll();

    @GetMapping("/goto")
    String exportToEs();
}
