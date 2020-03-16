package com.example.service.datasources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Li GQ 2018/11/2
 */
public class DataSourceChangeHelper {
    private static Logger logger = LoggerFactory.getLogger(DataSourceChangeHelper.class);

    public static void doChange(String sourceType, IDataSourceChangeCallbackWithoutResult action) {
        try {
            DynamicDataSource.setDataSource(sourceType);
            action.actionWithoutResult();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            DynamicDataSource.clearDataSource();
        }
    }

    public static <T> T doChangeWithResult(String sourceType, IDataSourceChangeCallback action) {
        Object result = null;
        try {
            DynamicDataSource.setDataSource(sourceType);
            result = action.actionWithResult();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            DynamicDataSource.clearDataSource();
        }
        return result == null ? null : (T) result;
    }
}
