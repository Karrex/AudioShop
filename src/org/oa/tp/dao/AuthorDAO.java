package org.oa.tp.dao;

import org.oa.tp.data.Author;

import java.util.List;

class AuthorDAO implements AbstractDAO<Author> {
    @Override
    public List<Author> loadAll() {
        return null;
    }

    @Override
    public Author findById(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(Author changed) {
        return false;
    }

    @Override
    public boolean add(Author item) {
        return false;
    }

    @Override
    public boolean saveAll() {
        return false;
    }
}
