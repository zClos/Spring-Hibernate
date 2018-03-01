package com.pvt.dao;

import java.io.Serializable;

public interface BaseDao<T> {

    void add(T t);

    void update(T t);

    T get(Class clazz, Serializable id);

    void delete(T t);
}
