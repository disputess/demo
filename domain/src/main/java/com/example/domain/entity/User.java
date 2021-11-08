package com.example.domain.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Document(indexName = "user1",shards = 5,replicas = 0,createIndex = true)
@Data
public class User implements Serializable {
    @Id
    private Integer userId;
    @Field(type= FieldType.Text,analyzer ="ik_max_word")
    private String userName;
    @Field(type= FieldType.Text,analyzer ="ik_max_word")
    private String userContent;
    @Field(type= FieldType.Integer)
    private Integer userAge;
    @Field(type= FieldType.Integer)
    private Integer userSex;
    @Field(type= FieldType.Text,analyzer ="ik_max_word")
    private Integer userLike;
}
