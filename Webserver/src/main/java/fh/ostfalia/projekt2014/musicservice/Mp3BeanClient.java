/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.musicservice;

import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3;

/**
 *
 * @author KingDCB
 */
public class Mp3BeanClient implements Mp3 {
     private Mp3 mp3Bean;
     private int mp3Id;
     private int artistId;
     private String mp3Title;
     private String artistName;

  
    /**
     * Creates a new instance of Mp3ManagedBean
     */
      public Mp3BeanClient() {
     
    }


    @Override
    public int getArtistId() {
        return artistId;
    }

    @Override
    public String getArtistName() {
        return artistName;
    }

    @Override
    public int getMp3Id() {
        return mp3Id;
    }

    @Override
    public String getMp3Title() {
        return mp3Title;
    }
}
