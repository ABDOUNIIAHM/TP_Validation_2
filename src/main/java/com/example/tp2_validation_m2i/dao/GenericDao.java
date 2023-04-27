package com.example.tp2_validation_m2i.dao;

import java.util.List;

public interface GenericDao<T, ID> {
    T create(T entity);

    List<T> findAll();

    T findById(ID id);

    void update(T entity);

    void delete(T entity);
}
