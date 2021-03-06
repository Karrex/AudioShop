package org.oa.tp.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Audio {
    @SerializedName("id")
    private final long id;
    @SerializedName("name")
    private final String name;
    @SerializedName("authorId")
    private final long authorId;
    @SerializedName("duration")
    private final int duration;
    @SerializedName("price")
    private int price;
    @SerializedName("genreId")
    private long genreId;
    @Expose
    private Author author;
    @Expose
    private Genre genre;

    public Audio(long id, String name, long authorId, int duration, int price, long genreId) {
        this.id = id;
        this.name = name;
        this.authorId = authorId;
        this.duration = duration;
        this.price = price;
        this.genreId = genreId;
    }

    public Audio(String name, long authorId, int duration, int price, long genreId) {
        id = 0;
        this.name = name;
        this.authorId = authorId;
        this.duration = duration;
        this.price = price;
        this.genreId = genreId;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAuthorId() {
        return authorId;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Audio{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                ", duration=" + duration +
                ", price=" + price +
                ", genreId=" + genreId +
                ", author=" + author +
                ", genre=" + genre +
                '}';
    }
}