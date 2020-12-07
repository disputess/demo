package com.example.service.utils.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: YUANEL
 * @Date: 2019/10/9 15:53
 * @Description:
 * 如果有对数据库操作，可以写子类继承此类（在invoke,doAfterAllAnalysed）方法中执行
 * 具体实现参考注释代码
 */
public  class DemoListener<T> extends AnalysisEventListener<T> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
  /*  private static int BATCH_COUNT = 5;
    List<T> insetDataList = new ArrayList<>();*/
    List<T> list = new ArrayList<>();
    /**
     *
     * @param data
     * @param context
     */
    @Override
    public void invoke(T data, AnalysisContext context) {
        list.add(data);
       /* insetDataList.add(data);
        if (list.size() >= BATCH_COUNT) {
            saveData(insetDataList);
            list.clear();
        }*/
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
      /*  saveData(insetDataList);*/
    }
}
