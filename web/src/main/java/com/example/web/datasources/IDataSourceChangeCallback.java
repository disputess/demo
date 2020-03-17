package com.example.web.datasources;

/**
 * @author Li GQ 2018/11/2
 */
@FunctionalInterface
public interface IDataSourceChangeCallback<T> {

    T actionWithResult();
}
