package org.oa.tp;

import org.oa.tp.dao.DAOFacade;
import org.oa.tp.data.Genre;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFacade daoFacade = new DAOFacade();
//        daoFacade.getGenreDAO().add(new Genre("Rock"));
        List<Genre> genres = daoFacade.getGenreDAO().loadAll();
        for (Genre genre : genres) {
            System.out.println(genre);
        }
        System.out.println("~~~~~~~`");
        System.out.println(daoFacade.getGenreDAO().findById(4));
        System.out.println("~~~~~~");
        daoFacade.getGenreDAO().delete(2);
        daoFacade.getGenreDAO().update(new Genre(5, "Rap"));
        List<Genre> genres1 = daoFacade.getGenreDAO().loadAll();
        for (Genre genre : genres1) {
            System.out.println(genre);
        }
        daoFacade.getGenreDAO().addAll(genres1);
        daoFacade.closeConnection();
    }
}