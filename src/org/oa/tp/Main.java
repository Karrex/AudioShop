package org.oa.tp;

import org.oa.tp.dao.DAOFacade;
import org.oa.tp.data.Audio;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DAOFacade daoFacade = new DAOFacade();
        daoFacade.getAudioDAO().add(new Audio("Hello", 4, 4, 5, 3));
        daoFacade.getAudioDAO().delete(5);
        List<Audio> audios = daoFacade.getAudioDAO().loadAll();
        for (Audio audio : audios) {
            System.out.println(audio);
        }
        System.out.println(daoFacade.getAudioDAO().findById(2));
        daoFacade.closeConnection();
    }
}