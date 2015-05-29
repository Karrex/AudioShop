package org.oa.tp;

import org.oa.tp.dao.DAOFacade;
import org.oa.tp.data.Author;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFacade daoFacade = new DAOFacade();
//        daoFacade.getAlbumDAO().add(new Album("without id", 3333));
//        List<Album> albums = daoFacade.getAlbumDAO().loadAll();
//        for (Album album : albums) {
//            System.out.println(album);
//        }
//        System.out.println("~~~~~~~~");
//        System.out.println(daoFacade.getAlbumDAO().findById(14));
//        daoFacade.getAlbumDAO().update(new Album(14, "update", 3333));
//        System.out.println(daoFacade.getAlbumDAO().findById(14));
//        daoFacade.getAlbumDAO().delete(17);
//        List<Album> albums1 = daoFacade.getAlbumDAO().loadAll();
//        for (Album album : albums1) {
//            System.out.println(album);
//        }

//        daoFacade.getAuthorDAO().add(new Author("Barak", "Obama", 50, "Male"));
        List<Author> authors = daoFacade.getAuthorDAO().loadAll();
        for (Author author : authors) {
            System.out.println(author);
        }
        System.out.println("~~~~~~~~~~");
        System.out.println(daoFacade.getAuthorDAO().findById(5));
        daoFacade.getAuthorDAO().delete(6);
        System.out.println("~~~~~~~~~~");
        daoFacade.getAuthorDAO().update(new Author(5, "Update", "Update", 100, "MALE"));
        List<Author> authors1 = daoFacade.getAuthorDAO().loadAll();
        for (Author author : authors1) {
            System.out.println(author);
        }
        System.out.println("~~~~~~~~~~~");
        daoFacade.getAuthorDAO().addAll(authors1);
        for (Author author : authors1) {
            System.out.println(author);
        }
        daoFacade.closeConnection();
    }
}