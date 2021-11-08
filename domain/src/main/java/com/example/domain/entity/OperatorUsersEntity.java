package com.example.domain.entity;


import lombok.Data;

import java.io.Serializable;

@Data
public class OperatorUsersEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long operatorUsersId;
    private String operatorName;
    private String adCode;
    private String adName;
    private String mobile;
}
