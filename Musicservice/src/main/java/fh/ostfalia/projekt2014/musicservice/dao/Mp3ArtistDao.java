/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice.dao;


import fh.ostfalia.projekt2014.musicservice.entities.Mp3Bean;
import fh.ostfalia.projekt2014.musicservice.entities.Mp3ArtistBean;
import fh.ostfalia.projekt2014.musicservice.util.Id3Tag;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author David
 */
@Stateless
public class Mp3ArtistDao implements Serializable{

    @PersistenceContext
    private EntityManager em;
    private Id3Tag id3;
    private String part;

    public void persistMp3Artist(Mp3ArtistBean mp3Artist) {
            em.persist(mp3Artist);
    }



    public void deleteMp3Artist(int mp3ArtistId) {
        em.remove(getMp3ArtistBean(mp3ArtistId));
    }

    public Mp3ArtistBean getMp3ArtistBean(int artistId) {
        return em.find(Mp3ArtistBean.class, artistId);
    }

    public String getMp3ArtistNameByMp3Id(int mp3Id) {
         return em.find(Mp3Bean.class, mp3Id).getMp3ArtistBean().getArtistName();
    }
    
     public String getMp3ArtistNameByArtistBean(Mp3ArtistBean mp3Artist) {
         return mp3Artist.getArtistName();
    }

    public List<Mp3ArtistBean> getAllMp3Artists() {
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
    
    public int doesNameExist(String name){
        int id = 0;
        Query query = em.createNamedQuery("getName");
        query.setParameter("name", name);
        List<Mp3ArtistBean> m = query.getResultList();
        
        
        if(m.size() > 0){             
            id = m.get(0).getArtistId();
        } 
        
        System.out.println("DOESEXIST?!?!?!?!: "+query.getResultList().size());
        
        return id;
    }



    
}
