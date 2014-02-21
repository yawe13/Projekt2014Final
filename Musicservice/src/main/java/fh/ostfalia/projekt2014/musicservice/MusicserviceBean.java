/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice;

import fh.ostfalia.projekt2014.musicservice.dao.Mp3ArtistDao;
import fh.ostfalia.projekt2014.musicservice.dao.Mp3Dao;
import fh.ostfalia.projekt2014.musicservice.entities.Mp3Bean;

//import fh.ostfalia.projekt2014.musicservice.entities.Mp3;
//import fh.ostfalia.projekt2014.musicservice.entities.Mp3Artist;

import fh.ostfalia.projekt2014.musicserviceremoteinterface.interfaces.Musicservice;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3Artist;



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
public class MusicserviceBean implements Serializable, Musicservice {
    @EJB
    private Mp3Dao mp3Dao;
    
    private Mp3ArtistDao mp3artist;
    private List <Mp3Artist> lArtists;
    public MusicserviceBean() {
        //mp3 = new Mp3Dao();
        mp3artist = new Mp3ArtistDao();
    }

    @Override
    public Mp3Bean getMp3(int mp3_id) {
        return mp3Dao.getMp3(mp3_id);
    }

   

    @Override
      public List<Mp3> getAllMp3s() {
        System.out.println("BIN IN GETALLMP3S Drin!!!!");
        return mp3Dao.getAllMp3s();
    }

   

    @Override
    public void upload() {
        try {
            mp3artist.upload();
        } catch (IOException ex) {
            Logger.getLogger(MusicserviceBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getPassedParameter() {
        return mp3artist.getPassedParameter();
    }
    

    
    /*
    @Override
    public String getMp3ArtistNameByArtistBean(Mp3Artist mp3Artist) {
        return null;
    }
    */

   
    
    
  



}
