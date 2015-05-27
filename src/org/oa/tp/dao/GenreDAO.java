package org.oa.tp.dao;

import org.oa.tp.data.Genre;

import java.util.List;

class GenreDAO implements AbstractDAO<Genre> {
    @Override
    public List<Genre> loadAll() {
        return null;
    }

    @Override
    public Genre findById(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(Genre changed) {
        return false;
    }

    @Override
    public boolean add(Genre item) {
        return false;
    }

    @Override
    public boolean saveAll() {
        return false;
    }
}
