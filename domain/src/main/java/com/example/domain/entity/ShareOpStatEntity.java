package com.example.domain.entity;
/**
 * @title: UsersEntity
 * @projectName demo
 * @description: TODO
 * @author 123
 * @date 2020/3/1811:13
 */

import lombok.Data;

import java.io.Serializable;

/**
 *@ClassName Users
 *@Description TODO
 *@Author 宋超杰
 *@Date 2020/3/18 11:13
 *@Version 1.0
 **/
@Data
public class ShareOpStatEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private Long shareId;

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

    public Long getShareId() {
        return shareId;
    }

    public void setShareId(Long shareId) {
        this.shareId = shareId;
    }
}
