package org.oa.tp.data;

import com.google.gson.annotations.SerializedName;

public class Album {
    @SerializedName("id")
    private final int id;
    @SerializedName("name")
    private String name;
    @SerializedName("year")
    private int year;

    public Album(int id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Album album = (Album) o;

        return id == album.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
