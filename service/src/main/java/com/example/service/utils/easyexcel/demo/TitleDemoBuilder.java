package com.example.service.utils.easyexcel.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YUANEL
 * @Date: 2019/10/12 10:48
 * @Description:
 */
public class TitleDemoBuilder {

    private final List<List<String>> head;

    public List<List<String>> getHead() {
        return head;
    }

    private TitleDemoBuilder(Builder builder) {
        head = builder.headBuilder;
    }

    public static class Builder {
        public List<List<String>> headBuilder;

        public Builder() {
            headBuilder = new ArrayList<>();
        }

        public Builder setColumnTitle(String columnTitle) {
            List<String> column = new ArrayList<String>();
            column.add(columnTitle);
            headBuilder.add(column);
            return this;
        }

        /**
         * 设置多行表头string[]数组 放的是列表头  如果需要合并表头只需把表头写成一样
         * @param multiRowTitle
         * @return
         */
        public Builder setMultiRowTitle(List<String[]> multiRowTitle){
            for (String[] rowTitleArray : multiRowTitle) {
                List<String> rowTitles = new ArrayList<>();
                for (String rowTitle : rowTitleArray) {
                    rowTitles.add(rowTitle);
                }
                headBuilder.add(rowTitles);
            }
            return this;
        }


        public Builder setMultiColumnTitle(String[] columnArray) {
            if (columnArray == null || columnArray.length == 0) {
                return this;
            }
            for (String columnTitle : columnArray) {
                List<String> column = new ArrayList<>();
                column.add(columnTitle);
                headBuilder.add(column);
            }
            return this;
        }

        public Builder setMultiColumnTitle(List<String> columnList) {
            if (columnList == null || columnList.size() == 0) {
                return this;
            }
            for (String columnTitle : columnList) {
                List<String> column = new ArrayList<>();
                column.add(columnTitle);
                headBuilder.add(column);
            }
            return this;
        }

        public TitleDemoBuilder build() {
            return new TitleDemoBuilder(this);
        }
    }


}
