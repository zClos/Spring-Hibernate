package com.pvt.dao.impl;

import com.pvt.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.openSession();
    }

    @Override
    public void add(T t) {
        getHibernateTemplate().save(t);
    }

    @Override
    public void update(T t) {
        getHibernateTemplate().update(t);
    }

    @Override
    public T get(Class clazz, Serializable id) {
        return (T) getHibernateTemplate().get(clazz, id);
    }

    @Override
    public void delete(T t) {
        getHibernateTemplate().delete(t);
    }
}
