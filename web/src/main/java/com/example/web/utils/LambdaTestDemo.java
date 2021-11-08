package com.example.web.utils;

import com.example.domain.entity.UsersEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaTestDemo {
   /* public static void main(String[] args) {
        Comparator<Integer> com = (x, y) -> Integer.compare(x,y) ;
    }*/


    public static void main(String[] args) {
        List<UsersEntity> userList = new ArrayList<>();
        for(int i =0;i<5;i++){
            UsersEntity user = new UsersEntity();
            user.setId(i);
            user.setName("张三"+i+"号");
            user.setAge(i+10);
            userList .add(user);
        }
       /* userList.stream()
                .filter((e) -> e.getId() >=3)
                .limit(1)
                .forEach(System.out::println);*/
        userList.stream()
                .filter((e) -> e.getId() >=3)
                .map(UsersEntity::getName)
                .forEach(System.out::println);
    }
}
