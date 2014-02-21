/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice;

import fh.ostfalia.projekt2014.musicservice.dao.Mp3ArtistDao;
import fh.ostfalia.projekt2014.musicservice.dao.Mp3Dao;

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
import javax.ejb.Stateless;
import javax.servlet.http.Part;

/**
 *
 * @author Mettbrötchen
 */
@Stateless
public class MusicserviceBean implements Serializable, Musicservice {

    private Mp3Dao mp3 = new Mp3Dao();
    private Mp3ArtistDao mp3artist;
    private List <Mp3Artist> lArtists;
    private List <Mp3> lMp3;
    public MusicserviceBean() {
        //mp3 = new Mp3Dao();
        mp3artist = new Mp3ArtistDao();
    }

    @Override
    public Mp3 getMp3(int mp3_id) {
        return mp3.getMp3(mp3_id);
    }

    @Override
    public String getMp3Title(int mp3_id) {
        return mp3.getMp3Title(mp3_id);
    }
   @Override
    public Mp3 getMp3ByArtist(int mp3ArtistId) {
        return mp3.getMp3ByArtist(mp3ArtistId);
    }

    @Override
    public int getMp3ArtistIdByMp3Id(int mp3_id) {
        return mp3.getMp3ArtistIdByMp3Id(mp3_id);
    }

    @Override
    public List<Mp3> getAllMp3s() {
        System.out.println("BIN IN GETALLMP3S Drin!!!!");

        System.out.println("MP3LIST1:"+ mp3.getAllMp3s().get(0).getMp3Title());
        List l = mp3.getAllMp3s();
        
        System.out.println("MP3LIST:"+ l.get(0));
        
        for(int i = 0; i <= l.size(); i++){
            lMp3.add((Mp3) mp3.getAllMp3s().get(i));
        }    
        return lMp3;
    }

    @Override
    public Mp3Artist getMp3ArtistBean(int artistId) {
        return (Mp3Artist) mp3artist.getMp3ArtistBean(artistId);
    }

    @Override
    public String getMp3ArtistNameByMp3Id(int mp3Id) {
        return mp3artist.getMp3ArtistNameByMp3Id(mp3Id);
    }

    @Override
    public Part getPart() {
        return mp3artist.getPart();
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
    
    @Override
    public List<Mp3Artist> getAllMp3Artists() {
        List l = mp3artist.getAllMp3Artists();
            
        for(int i = 0; i <= l.size(); i++){
            lArtists.add((Mp3Artist) mp3artist.getAllMp3Artists().get(i));
        }    
        return lArtists;
    }
    
    /*
    @Override
    public String getMp3ArtistNameByArtistBean(Mp3Artist mp3Artist) {
        return null;
    }
    */
    
    
    @Override
    public String getMp3ArtistNameByArtistBean(Mp3Artist mp3Artist) {
        return mp3artist.getMp3ArtistNameByArtistBean((fh.ostfalia.projekt2014.musicservice.entities.Mp3Artist) mp3Artist);
    }



}
