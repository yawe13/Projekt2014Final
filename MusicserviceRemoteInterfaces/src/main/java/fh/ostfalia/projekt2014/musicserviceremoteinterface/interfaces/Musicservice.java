/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.musicserviceremoteinterface.interfaces;

import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3Artist;
import java.util.List;
import javax.ejb.Remote;
import javax.servlet.http.Part;


/**
 *
 * @author Mettbrötchen
 */
@Remote
public interface Musicservice {
    public Mp3 getMp3(int mp3_id);
    public String getMp3Title(int mp3_id);
    public Mp3 getMp3ByArtist(int mp3ArtistId);
    public int getMp3ArtistIdByMp3Id(int mp3_id);
    public List<Mp3> getAllMp3s();
    
    public Mp3Artist getMp3ArtistBean(int artistId);
    public String getMp3ArtistNameByArtistBean(Mp3Artist mp3Artist);
    public String getMp3ArtistNameByMp3Id(int mp3Id);
    public List<Mp3Artist> getAllMp3Artists();
    public String getPassedParameter();
    public Part getPart();
    public void upload();
}
