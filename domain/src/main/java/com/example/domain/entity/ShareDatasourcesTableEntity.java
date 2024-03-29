package com.example.domain.entity;

public class ShareDatasourcesTableEntity {
    private Long id;

    private String phone;

    private String backOne;

    private String backTwo;

    private String backThree;
    private Integer shareId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getBackOne() {
        return backOne;
    }

    public void setBackOne(String backOne) {
        this.backOne = backOne == null ? null : backOne.trim();
    }

    public String getBackTwo() {
        return backTwo;
    }

    public void setBackTwo(String backTwo) {
        this.backTwo = backTwo == null ? null : backTwo.trim();
    }

    public String getBackThree() {
        return backThree;
    }

    public void setBackThree(String backThree) {
        this.backThree = backThree == null ? null : backThree.trim();
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    @Override
    public String toString() {
        return "ShareDatasourcesTableEntity{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", backOne='" + backOne + '\'' +
                ", backTwo='" + backTwo + '\'' +
                ", backThree='" + backThree + '\'' +
                ", shareId=" + shareId +
                '}';
    }
}