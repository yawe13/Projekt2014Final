/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice;

import fh.ostfalia.projekt2014.musicservice.dao.Mp3ArtistDao;
import fh.ostfalia.projekt2014.musicservice.dao.Mp3DaoImpl;
import fh.ostfalia.projekt2014.musicservice.dao.Mp3DaoLocal;
import fh.ostfalia.projekt2014.musicservice.entities.Mp3Artist;
import fh.ostfalia.projekt2014.musicservice.entities.Mp3Bean;

//import fh.ostfalia.projekt2014.musicservice.entities.Mp3;
//import fh.ostfalia.projekt2014.musicservice.entities.Mp3Artist;

import fh.ostfalia.projekt2014.musicserviceremoteinterface.interfaces.Musicservice;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3;




import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author Mettbrötchen
 */
@Stateless
public class MusicserviceBean implements Musicservice {
    @EJB
    private Mp3DaoLocal mp3Dao;
    
    //private Mp3ArtistDao mp3artist;
    private List <Mp3Artist> lArtists;


    @Override
    public Mp3 getMp3(int mp3_id) {
        return mp3Dao.getMp3(mp3_id);
    }

   

    @Override
      public List<Mp3> getAllMp3s() {
        System.out.println("BIN IN GETALLMP3S Drin!!!!");
        return mp3Dao.getAllMp3();
    }

   

    @Override
    public void upload() {
      
    }

    @Override
    public String getPassedParameter() {
        //return mp3artist.getPassedParameter();
        return null; 
    }
   

    
    /*
    @Override
    public String getMp3ArtistNameByArtistBean(Mp3Artist mp3Artist) {
        return null;
    }
    */

}
