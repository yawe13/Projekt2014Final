/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice;


import fh.ostfalia.projekt2014.musicservice.dao.Mp3ArtistDao;
import fh.ostfalia.projekt2014.musicservice.dao.Mp3DaoImpl;
import fh.ostfalia.projekt2014.musicservice.dao.Mp3DaoLocal;
import fh.ostfalia.projekt2014.musicservice.entities.Mp3ArtistBean;


//import fh.ostfalia.projekt2014.musicservice.entities.Mp3;
//import fh.ostfalia.projekt2014.musicservice.entities.Mp3Artist;

import fh.ostfalia.projekt2014.musicserviceremoteinterface.interfaces.Musicservice;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3;
import java.io.IOException;
import java.io.InputStream;





import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.Part;


/**
 *
 * @author Mettbrötchen
 */
@Stateless
public class MusicserviceBean implements Musicservice {

    @EJB
    private Mp3DaoLocal mp3Dao;
    
    //private Mp3ArtistDao mp3ArtistDao;
    //@EJB
    //private Mp3DaoImpl mp3DaoImpl;
    
    private List <Mp3ArtistBean> lArtists;


    @Override
    public Mp3 getMp3(int mp3_id) {
        return mp3Dao.getMp3(mp3_id);
    }

   

    @Override
      public List<Mp3> getAllMp3s() {
        return mp3Dao.getAllMp3();
    }

   

    @Override
    public void upload(String part) {
        
            mp3Dao.upload(part);
       
    }

    @Override
    public String getPassedParameter() {
        //return mp3ArtistDao.getPassedParameter();
        return null;
    }
   

    
    /*
    @Override
    public String getMp3ArtistNameByArtistBean(Mp3Artist mp3Artist) {
        return null;
    }
    */

}
