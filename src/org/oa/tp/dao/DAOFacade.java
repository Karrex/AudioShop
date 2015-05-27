package org.oa.tp.dao;

import org.oa.tp.data.Album;
import org.oa.tp.data.Audio;
import org.oa.tp.data.Author;
import org.oa.tp.data.Genre;

public class DAOFacade {
    private final AlbumDAO albumDAO = new AlbumDAO();
    private final AudioDAO audioDAO = new AudioDAO();
    private final AuthorDAO authorDAO = new AuthorDAO();
    private final GenreDAO genreDAO = new GenreDAO();

    public AbstractDAO<Album> getAlbumDAO() {
        return albumDAO;
    }

    public AbstractDAO<Audio> getAudioDAO() {
        return audioDAO;
    }

    public AbstractDAO<Author> getAuthorDAO() {
        return authorDAO;
    }

    public AbstractDAO<Genre> getGenreDAO() {
        return genreDAO;
    }
}
