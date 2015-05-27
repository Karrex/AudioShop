package org.oa.tp.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.oa.tp.data.Audio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AudioDAO implements AbstractDAO<Audio> {

    private static final String PATH = "audio.txt";
    private Set<Audio> items = new HashSet<>();

    @Override
    public List<Audio> loadAll() {
        items.clear();
        Gson gson = new Gson();
        try (FileReader fileReader = new FileReader(PATH)) {
            Type collectionType = new TypeToken<List<Audio>>() {

            }.getType();
            List<Audio> audios = gson.fromJson(fileReader, collectionType);
            items.addAll(audios);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(items);
    }

    @Override
    public Audio findById(long id) {
        for (Audio audio : items) {
            if ((id == audio.getId())) {
                return audio;
            }
        }
        return null;
    }

    @Override
    public boolean delete(long id) {
        Audio audio = findById(id);
        if (audio == null) {
            return false;
        }
        return items.remove(audio);
    }

    @Override
    public boolean update(Audio changed) {
        Audio audio = findById(changed.getId());
        if (audio == null) {
            return false;
        }
        audio.setAuthor(changed.getAuthor());
        audio.setGenreId(changed.getGenreId());
        audio.setGenre(changed.getGenre());
        audio.setPrice(changed.getPrice());
        return true;
    }

    @Override
    public boolean add(Audio item) {
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
