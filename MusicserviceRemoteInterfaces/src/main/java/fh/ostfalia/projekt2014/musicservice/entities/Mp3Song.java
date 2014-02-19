/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice.entities;

import javax.ejb.Remote;

/* Hinweis:
 * JEE-Nameskonventionen:
 * Interfaces = Mp3Song
 * zugehörige Managed Beans = ArtistDaoBean
 * 
 */

/**
 * 
 * @author Yannick
 */
@Remote
public interface Mp3Song {
    public String getSongName();
    public String getArtistName();
}
