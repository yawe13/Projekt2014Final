/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice;

import fh.ostfalia.projekt2014.musicservice.entities.Mp3Song;
import javax.ejb.Stateful;


/**
 * Implementiert Mp3Song (eigene SST nach außen)
 * @author Yannick
 */
@Stateful
public class Mp3SongBean implements Mp3Song {

    @Override
    public String getSongName() {
        
        return "MOLLI";
    }

    @Override
    public String getArtistName() {
        return "DJ EY";
    }


}
