package com.example.service.utils.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;

import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Auther: YUANEL
 * @Date: 2019/10/9 11:28
 * @Description:
 */
public class EasyExcelUtils {
    private static Logger logger = LoggerFactory.getLogger(EasyExcelUtils.class);

    private final static String xls = "xls";
    private final static String xlsx = "xlsx";





    /**
     * 下载excel（可适用多行的表头）
     *
     * @param response
     * @param demo      生成的excel表头对象（涉及到表头的合并可在对象中用注解完成）
     * @param list      行内容
     * @param fileName
     * @param sheerName
     * @param <T>
     */
    public static <T> void downLoadMultiRowTitle(HttpServletResponse response, Class<T> demo, List<T> list, String
            fileName, String sheerName) throws IOException {
        // 这里注意 有同学反应下载的文件名不对。这个时候 请别使用swagger 他会有影响
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcel.write(outputStream, demo).sheet(sheerName).doWrite(list);
        } catch (UnsupportedEncodingException e) {
            logger.error("导出报错UnsupportedEncodingException：", e);
            throw e;
        } catch (IOException e) {
            logger.error("导出报错IOException：", e);
            throw e;
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    logger.error("关闭outputStream流报错IOException：", e);
                    throw e;
                }
            }
        }
    }


}
