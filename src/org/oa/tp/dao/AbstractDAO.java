package org.oa.tp.dao;

import java.util.List;

public interface AbstractDAO<T> {
    List<T> loadAll();

    T findById(long id);

    boolean delete(long id);

    boolean update(T changed);

    boolean add(T item);

    boolean saveAll();
}