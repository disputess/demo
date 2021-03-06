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
public class UsersEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
