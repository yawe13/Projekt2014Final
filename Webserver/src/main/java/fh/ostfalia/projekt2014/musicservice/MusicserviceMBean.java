/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice;

import fh.ostfalia.projekt2014.beanmanager.RemoteManagedBean;
import fh.ostfalia.projekt2014.loginserviceremoteinterfaces.interfaces.Login;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3Artist;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.interfaces.Musicservice;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.servlet.http.Part;

/**
 *
 * @author Mettbrötchen
 */
public class MusicserviceMBean extends RemoteManagedBean implements Musicservice {

    private Musicservice musicserviceBean;

    public MusicserviceMBean() {
        super("localhost", "3700", "java:global/Musicservice/MusicserviceBean");
        System.out.println("ENDELookup");
    }

    @PostConstruct
    public void initBean() {
        //Holen der entfernten Loginbean bzw. deren Stub-Objekt
        musicserviceBean = (Musicservice) super.getObject();
    }

    @Override
    public Mp3 getMp3(int mp3_id) {
        return musicserviceBean.getMp3(mp3_id);
    }

    @Override
    public String getMp3Title(int mp3_id) {
        return musicserviceBean.getMp3Title(mp3_id);
    }

    @Override
    public Mp3 getMp3ByArtist(int mp3ArtistId) {
        return musicserviceBean.getMp3ByArtist(mp3ArtistId);
    }

    @Override
    public int getMp3ArtistIdByMp3Id(int mp3_id) {
        return musicserviceBean.getMp3ArtistIdByMp3Id(mp3_id);
    }

    @Override
    public List<Mp3> getAllMp3s() {
        return musicserviceBean.getAllMp3s();
    }

    @Override
    public Mp3Artist getMp3ArtistBean(int artistId) {
        return musicserviceBean.getMp3ArtistBean(artistId);
    }

    @Override
    public String getMp3ArtistNameByArtistBean(Mp3Artist mp3Artist) {
        return musicserviceBean.getMp3ArtistNameByArtistBean(mp3Artist);
    }

    @Override
    public String getMp3ArtistNameByMp3Id(int mp3Id) {
        return musicserviceBean.getMp3ArtistNameByMp3Id(mp3Id);
    }

    @Override
    public List<Mp3Artist> getAllMp3Artists() {
        return musicserviceBean.getAllMp3Artists();
    }

    @Override
    public Part getPart() {
        return musicserviceBean.getPart();
    }

    @Override
    public void upload() {
        musicserviceBean.upload();
    }

    @Override
    public String getPassedParameter() {
        return musicserviceBean.getPassedParameter();
    }
}
