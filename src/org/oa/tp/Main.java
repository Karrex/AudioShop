package org.oa.tp;

import org.oa.tp.dao.DAOFacade;
import org.oa.tp.data.Album;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFacade daoFacade = new DAOFacade();
        Album item = new Album(1, "TTT", 2000);
        Album item1 = new Album(2, "QQQ", 2111);
        daoFacade.getAlbumDAO().add(item);
        daoFacade.getAlbumDAO().add(item1);
        daoFacade.getAlbumDAO().update(new Album(1, "QWERTY", 2010));
//        daoFacade.getAlbumDAO().delete(1);
//        daoFacade.getAlbumDAO().delete(2);
        daoFacade.getAlbumDAO().saveAll();
        List<Album> albums = daoFacade.getAlbumDAO().loadAll();
        System.out.println(albums);
    }
}