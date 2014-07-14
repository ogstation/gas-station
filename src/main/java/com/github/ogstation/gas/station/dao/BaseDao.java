package com.github.ogstation.gas.station.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import java.util.List;

public abstract class BaseDao<T> extends SqlSessionDaoSupport
{
    public T get(String namespace, String key)
    {
        return getSqlSession().selectOne(namespace, key);
    }

    public List<T> get(String namespace, Pageable pageable)
    {
        return getSqlSession().selectList(namespace, pageable);
    }

    public T create(String namespace, T t)
    {
        int result = getSqlSession().insert(namespace, t);
        return getResult(t, result);
    }

    public T update(String namespace, T t)
    {
        int result = getSqlSession().update(namespace, t);
        return getResult(t, result);
    }

    public T delete(String namespace, String key)
    {
        int result = getSqlSession().delete(namespace, key);
        return getResult(get(namespace, key), result);
    }

    private T getResult(T t, int result)
    {
        return result == 1 ? t : null;
    }

    @Override
    @Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate)
    {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }

    protected <S> S getMapper(Class<S> clazz)
    {
        return getSqlSession().getMapper(clazz);
    }
}
