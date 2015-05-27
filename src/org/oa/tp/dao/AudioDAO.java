package org.oa.tp.dao;

import org.oa.tp.data.Audio;

import java.util.List;

class AudioDAO implements AbstractDAO<Audio>{
    @Override
    public List<Audio> loadAll() {
        return null;
    }

    @Override
    public Audio findById(long id) {
        return null;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public boolean update(Audio changed) {
        return false;
    }

    @Override
    public boolean add(Audio item) {
        return false;
    }

    @Override
    public boolean saveAll() {
        return false;
    }
}
