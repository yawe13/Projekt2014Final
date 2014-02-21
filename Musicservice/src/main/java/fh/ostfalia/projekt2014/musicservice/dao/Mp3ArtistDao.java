/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice.dao;


import fh.ostfalia.projekt2014.musicservice.entities.Mp3;
import fh.ostfalia.projekt2014.musicservice.entities.Mp3Artist;
import fh.ostfalia.projekt2014.musicservice.util.Id3Tag;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


/**
 *
 * @author David
 */
@Stateless
public class Mp3ArtistDao {

    @PersistenceContext
    private EntityManager em;
    //@Resource
    //UserTransaction ut;
    private Id3Tag id3;
    private Part part;

    public void persistMp3Artist(Mp3Artist mp3Artist) {
            em.persist(mp3Artist);
    }

    public void upload() throws IOException {
        id3 = new Id3Tag();
        File file = new File("C:\\Users\\Mettbrötchen\\Documents\\NetBeansProjects\\Projekt2014Final\\Musicservice\\Upload\\" + part.getSubmittedFileName());

        Mp3Artist mp3ArtistBean;

        Mp3 mp3Bean = new Mp3();
        mp3Bean = id3.readMp3File(file);
        System.out.println(mp3Bean.getMp3Title());

        //UserDaoLocal UserDaoLocal = new UserDaoLocal();
        mp3ArtistBean = mp3Bean.getMp3ArtistBean();

        mp3ArtistBean.addMp3Bean(mp3Bean);//Zuordnung Artist->Titel(Liste von Titeln)

        this.persistMp3Artist(mp3ArtistBean);
    }

    public void deleteMp3Artist(int mp3ArtistId) {
        em.remove(getMp3ArtistBean(mp3ArtistId));
    }

    public Mp3Artist getMp3ArtistBean(int artistId) {
        return em.find(Mp3Artist.class, artistId);
    }

    public String getMp3ArtistNameByMp3Id(int mp3Id) {
         return em.find(Mp3.class, mp3Id).getMp3ArtistBean().getArtistName();
    }
    
     public String getMp3ArtistNameByArtistBean(Mp3Artist mp3Artist) {
         return mp3Artist.getArtistName();
    }

    public List<Mp3Artist> getAllMp3Artists() {
        return em.createNamedQuery("Mp3Artist.getAll").getResultList();
    }

    private String passedParameter;

    public String getPassedParameter() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        this.passedParameter = (String) facesContext.getExternalContext().
                getRequestParameterMap().get("id");
        return this.passedParameter;
    }

    public void setPassedParameter(String passedParameter) {
        this.passedParameter = passedParameter;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
    
}
