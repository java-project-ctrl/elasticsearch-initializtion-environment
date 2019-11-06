package com.example.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Table: scenery_data
 */
@Table(name="scenery_data")
public class SceneryData implements Serializable {
    /**
     * Column: id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * Column: name
     */
    @Column(name = "name")
    private String name;

    /**
     * Column: address
     */
    @Column(name = "address")
    private String address;

    /**
     * Column: star
     */
    @Column(name = "star")
    private String star;

    /**
     * Column: price
     */
    @Column(name = "price")
    private String price;

    /**
     * Column: groupName
     */
    @Column(name = "groupName")
    private String groupname;

    /**
     * Column: specMap
     */
    @Column(name = "specMap")
    private String specmap;

    /**
     * Column: categoryName
     */
    @Column(name = "categoryName")
    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star == null ? null : star.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname == null ? null : groupname.trim();
    }

    public String getSpecmap() {
        return specmap;
    }

    public void setSpecmap(String specmap) {
        this.specmap = specmap == null ? null : specmap.trim();
    }

    @Override
    public String toString() {
        return "SceneryData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", star='" + star + '\'' +
                ", price='" + price + '\'' +
                ", groupname='" + groupname + '\'' +
                ", specmap='" + specmap + '\'' +
                '}';
    }
}