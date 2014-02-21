/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice.dao;


import fh.ostfalia.projekt2014.musicservice.entities.Mp3Bean;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author David
 */
@Stateless
public class Mp3Dao {

    @PersistenceContext
    private EntityManager em;
    //@Resource
   //private UserTransaction ut;

    private byte[] fileContent;

    private Mp3ArtistDao mp3ArtistDao;

    public void addMp3List(ArrayList<Mp3> mp3BeanList) {
   

            for (int i = 0; i <= mp3BeanList.size(); i++) {
                Mp3 tempMp3Bean = mp3BeanList.get(i);
                em.persist(tempMp3Bean);
            }


    }

    public void deleteMp3(int mp3_id) {
        em.remove(getMp3(mp3_id));
    }

    public Mp3Bean getMp3(int mp3_id) {
        System.out.println("GET MP333333333333");
        return em.find(Mp3Bean.class, mp3_id);
    }

    public Mp3 getMp3ByArtist(int mp3ArtistId) {
        return em.find(Mp3.class, mp3ArtistId);
    }

    public int getMp3ArtistIdByMp3Id(int mp3Id) {
        Mp3 mp3Bean = em.find(Mp3.class, mp3Id);
        
        return mp3Bean.getArtistId();
    }

    public String getMp3Title(int mp3Id) {
        return em.find(Mp3.class, mp3Id).getMp3Title();
    }

    public byte[] getMp3File(int mp3Id) {
        return em.find(Mp3Bean.class, mp3Id).getMp3File();
    }

    public List<Mp3> getAllMp3s() {
        System.out.println("MP3 DAOOOOOOO");
        List<Mp3> mp3List =  em.createNamedQuery("Mp3.getAll").getResultList();
  
        
       
        
        return mp3List;
    }

    // Methoden zum Extrahieren der Id aus der URI, um Mp3 zu identifizieren 
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

    public void addMp3(Mp3 mp3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
