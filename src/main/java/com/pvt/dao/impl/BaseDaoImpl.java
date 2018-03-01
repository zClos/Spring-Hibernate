package com.pvt.dao.impl;

import com.pvt.dao.BaseDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

public class BaseDaoImpl<T> implements BaseDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public void add(T t) {
        entityManager.persist(t);
    }

    @Override
    public void update(T t) {
        entityManager.merge(t);
        entityManager.flush();
    }

    @Override
    public T get(Class clazz, Serializable id) {
        return (T) entityManager.find(clazz, id);
    }

    @Override
    public void delete(Class clazz, Serializable id) {
        entityManager.remove(entityManager.find(clazz, id));
        entityManager.flush();
    }
}
