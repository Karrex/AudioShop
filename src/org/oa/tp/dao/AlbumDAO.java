package org.oa.tp.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.oa.tp.data.Album;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AlbumDAO implements AbstractDAO<Album> {

    private static final String PATH = "album.txt";

    private Set<Album> items = new HashSet<>();

    @Override
    public List<Album> loadAll() {
        items.clear();
        Gson gson = new Gson();

        try (FileReader fileReader = new FileReader(PATH)) {
            Type collectionType = new TypeToken<List<Album>>() {
            }.getType();
            List<Album> albums = gson.fromJson(fileReader, collectionType);
            items.addAll(albums);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(items);
    }

    @Override
    public Album findById(long id) {
        for (Album album : items) {
            if (id == album.getId()) {
                return album;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        Album album = findById(id);
        if (album == null) {
            return false;
        }
        return items.remove(album);
    }

    @Override
    public boolean update(Album changed) {
        Album album = findById(changed.getId());
        if (album == null) {
            return false;
        }
        album.setName(changed.getName());
        album.setYear(changed.getYear());
        return true;
    }

    @Override
    public boolean add(Album item) {
        return items.add(item);
    }

    @Override
    public boolean saveAll() {
        Gson gson = new Gson();
        try (FileWriter fileWriter = new FileWriter(PATH)) {
            gson.toJson(items, fileWriter);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}