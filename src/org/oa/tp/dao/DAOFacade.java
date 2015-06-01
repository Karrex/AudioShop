package org.oa.tp.dao;

import org.oa.tp.data.Album;
import org.oa.tp.data.Audio;
import org.oa.tp.data.Author;
import org.oa.tp.data.Genre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOFacade {
    private final AlbumDAO albumDAO;
    private final AudioDAO audioDAO;
    private final AuthorDAO authorDAO;
    private final GenreDAO genreDAO;

    private Statement statement;
    private Connection connection;

    public DAOFacade() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:test.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection == null) {
            System.exit(1);
        }
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        albumDAO = new AlbumDAO(statement, connection);
        authorDAO = new AuthorDAO(statement, connection);
        genreDAO = new GenreDAO(statement, connection);
        audioDAO = new AudioDAO(statement, connection);
    }

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

    public void closeConnection() {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}