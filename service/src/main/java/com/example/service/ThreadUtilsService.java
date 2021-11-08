package com.example.service;

import com.example.domain.entity.BaseDto;

import java.util.List;

public interface ThreadUtilsService<T extends BaseDto> {

    /**
     * 获取数据数量
     * @param dto
     * @return
     */
    Long getListCount(T dto);


    /**
     * 获取数据
     * pageNum  分页查询开始页必传
     * pageSize 每页数据量
     * @param dto
     * @return
     */
    List getThreadList(T dto, Integer pageNum, Integer pageSize);
}
