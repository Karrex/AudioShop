package org.oa.tp.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.oa.tp.data.Author;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AuthorDAO implements AbstractDAO<Author> {

    private static final String PATH = "author.txt";
    private Set<Author> items = new HashSet<>();

    @Override
    public List<Author> loadAll() {
        items.clear();
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader(PATH)) {
            Type CollectionType = new TypeToken<List<Author>>() {

            }.getType();
            List<Author> authors = gson.fromJson(fileReader, CollectionType);
            items.addAll(authors);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(items);
    }

    @Override
    public Author findById(long id) {
        for (Author author : items) {
            if (id == author.getId()) {
                return author;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        Author author = findById(id);
        return items.remove(author);
    }

    @Override
    public boolean update(Author changed) {
        Author author = findById(changed.getId());
        if (author == null) {
            return false;
        }
        author.setAge(changed.getAge());
        author.setGender(changed.getGender());
        return true;
    }

    @Override
    public boolean add(Author item) {
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