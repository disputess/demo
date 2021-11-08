package com.example.service;

import com.example.domain.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserElasticSearchRepository extends ElasticsearchRepository<User,Integer> {
}
