package org.oa.tp.dao;

import org.oa.tp.data.Author;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class AuthorDAO implements AbstractDAO<Author> {

    private static final String PATH = "author.txt";
    private Set<Author> items = new HashSet<>();

    private Connection connection;
    private Statement statement;

    public AuthorDAO(Statement statement, Connection connection) {
        this.statement = statement;
        this.connection = connection;
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS author " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "firstName TEXT NOT NULL, " +
                    "lastName TEXT NOT NULL, " +
                    "age INTEGER NOT NULL, " +
                    "gender TEXT NOT NULL); ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Author> loadAll() {
        List<Author> authors = new ArrayList<>();

        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM author");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                Author author = new Author(id, firstName, lastName, age, gender);
                authors.add(author);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }

    @Override
    public Author findById(long objectId) {
        Author author = null;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM author WHERE id = " + objectId + ";");
            int id = resultSet.getInt("id");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            int age = resultSet.getInt("age");
            String gender = resultSet.getString("gender");
            author = new Author(id, firstName, lastName, age, gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return author;
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
        try {
            statement.executeUpdate("INSERT INTO author (firstName, lastName, age, gender)"
                    + " VALUES ('" + item.getFirstName() + "','" + item.getLastName()
                    + "','" + item.getAge() + "','" + item.getGender()
                    + "')");
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<Author> collection) {
        return false;
    }
}