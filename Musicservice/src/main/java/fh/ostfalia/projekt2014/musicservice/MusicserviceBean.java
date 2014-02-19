/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice;

import fh.ostfalia.projekt2014.musicservice.Mp3SongBean;
import fh.ostfalia.projekt2014.musicservice.interfaces.Musicservice;
import javax.ejb.Stateful;

/**
 *
 * @author Yannick
 */
@Stateful
public class MusicserviceBean implements Musicservice {

    Mp3SongBean mp3SongBean;
    @Override
    public Mp3SongBean getMp3Song() {
       return null;
    }


}
