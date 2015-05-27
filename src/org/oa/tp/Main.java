package org.oa.tp;

import org.oa.tp.dao.AbstractDAO;
import org.oa.tp.dao.DAOFacade;
import org.oa.tp.data.Album;
import org.oa.tp.data.Audio;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFacade daoFacade = new DAOFacade();
        Audio audio = new Audio(1, "Hello", 25, 4, 5, 34);
        daoFacade.getAudioDAO().add(audio);
        daoFacade.getAudioDAO().saveAll();
        List<Audio> audios = daoFacade.getAudioDAO().loadAll();
        System.out.println(audios);
    }
}