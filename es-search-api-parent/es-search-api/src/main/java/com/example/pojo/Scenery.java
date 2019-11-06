package com.example.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = "scenery", type = "docs")
public class Scenery implements Serializable {
    @Id
    private Long id;

    @Field(type = FieldType.Text, analyzer = "ik_max_word",index = true,store = false,searchAnalyzer = "ik_max_word")
    private String name;

    @Field(type = FieldType.Text,analyzer = "ik_smart",index = true,store = false,searchAnalyzer = "ik_smart")
    private String address;

    //类目名称
    @Field(type = FieldType.Text ,analyzer = "ik_smart",index = true,store = false,searchAnalyzer = "ik_smart")
    private String categoryName;

    //组团名称
    @Field(type = FieldType.Keyword)
    private String groupName;

    //星级
    private String star;

    //门票价
    private String price;

    //es实体类中不能有map集合，否则json转换会失败
    //观光详情
    /*private Map<String,Object> specMap;

    public Map<String, Object> getSpecMap() {
        return specMap;
    }

    public void setSpecMap(Map<String, Object> specMap) {
        this.specMap = specMap;
    }*/

    /*private SceneryData sd;

        public SceneryData getSd() {
            return sd;
        }

        public void setSd(SceneryData sd) {
            this.sd = sd;
        }
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

}
