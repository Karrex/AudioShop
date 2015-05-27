package org.oa.tp.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.oa.tp.data.Genre;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class GenreDAO implements AbstractDAO<Genre> {

    private static final String PATH = "genre.txt";
    private Set<Genre> items = new HashSet<>();

    @Override
    public List<Genre> loadAll() {
        items.clear();
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader(PATH)) {
            Type collectionType = new TypeToken<List<Genre>>() {
            }.getType();
            List<Genre> genre = gson.fromJson(fileReader, collectionType);
            items.addAll(genre);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(items);
    }

    @Override
    public Genre findById(long id) {
        for (Genre genre : items) {
            if (id == genre.getId()) {
                return genre;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        Genre genre = findById(id);
        return items.remove(genre);
    }

    @Override
    public boolean update(Genre changed) {
        Genre genre = findById(changed.getId());
        if (genre == null) {
            return false;
        }
        genre.setName(changed.getName());
        return true;
    }

    @Override
    public boolean add(Genre item) {
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
