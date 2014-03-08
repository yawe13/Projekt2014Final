/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice.dao;

import fh.ostfalia.projekt2014.musicservice.entities.Mp3ArtistBean;
import fh.ostfalia.projekt2014.musicservice.entities.Mp3Bean;
import fh.ostfalia.projekt2014.musicservice.util.Id3Tag;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
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
public class Mp3DaoImpl implements Mp3DaoLocal {
     @EJB
     Mp3ArtistDao mp3ArtistDao;
    private static final long serialVersionUID = 1L;
    @PersistenceContext
    private EntityManager em;
    private Id3Tag id3;

    public void addMp3List(ArrayList<Mp3> mp3BeanList) {
        for (int i = 0; i <= mp3BeanList.size(); i++) {
            Mp3 tempMp3Bean = mp3BeanList.get(i);
            em.persist(tempMp3Bean);
        }
    }

    /**
     * Speichern einer Mp3Bean in die Datenbank
     *
     * @param mp3Bean
     */
    public void persistMp3(Mp3Bean mp3Bean) {
        mp3Bean = checkMp3Artist(mp3Bean);
        em.persist(mp3Bean);
    }
    
    public Mp3Bean checkMp3Artist(Mp3Bean mp3Bean){
        int id = mp3ArtistDao.doesNameExist(mp3Bean.getArtistName());
        
        if(id > 0){
            System.out.println("ARTIST MIT DER NUMMER "+id+" VORHANDEN");
            //mp3Bean.editArtistId(id);
            //mp3Bean.setMp3ArtistBean(null);
        } else{
            System.out.println("NOCH KEIN ARTIST VORHANDEN");
        }
        
        return mp3Bean;
    }

    /**
     * Löschung einer Mp3 aus der Datenbank
     *
     * @param mp3_id
     */
    public void deleteMp3(int mp3_id) {
        em.remove(getMp3(mp3_id));
    }

    /**
     * Holt eine Mp3 aus der Datenbank
     *
     * @param mp3_id
     * @return Mp3Bean
     */
    @Override
    public Mp3Bean getMp3(int mp3_id) {
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

    @Override
    public List<Mp3> getAllMp3() {
        Query queryMp3List = em.createQuery("SELECT e FROM Mp3 e");
        List<Mp3Bean> mp3BeanList = queryMp3List.getResultList();
        return new LinkedList<Mp3>(mp3BeanList);
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

    /**
     * Ausführen eines Uploads Diese Methode wird aus dem Webfrontend
     * aufgerufen. Es wird die Jid3lib Libary zum auslesen der Informationen
     * einer Mp3 Datei verwendet. Der Titel und der Artist werden ausgelesen und
     * in die Datenbank gespeichert. Der Parameter part enthält unter anderem
     * den Namen der Datei (der Name wird mit Hilfe der Methode getFileName
     * extrahiert) der für die id3Tag Libary gebraucht wird.
     *
     * @param part
     */
    @Override
    public void upload(String part) {
        /**
         * Initialisierung der Id3Tag Klasse zum verwenden der jid3lib Libary
         */
        id3 = new Id3Tag();

        /**
         * Die Id3Tag Klasse braucht ein File zum auslesen. Dieses wird mit
         * Hilfe der Methode getFileName und dem Parameter part (welcher aus der
         * Komponente im Webfrontend mitgeliefert wird) erstellt
         */
        File file = new File("C:\\Users\\Mettbroetchen\\Documents\\NetBeansProjects\\Projekt2014Final\\Musicservice\\Uploads\\" + getFileName(part));

        
        /**
         * Initialisierung der Mp3Bean
         */
        Mp3Bean mp3Bean = new Mp3Bean();

        /**
         * Die Methode readMp3File aus der Id3Tag Klasse liest die notwendigen
         * Informationen aus der Datei aus returned diese in Form einer Mp3Bean
         */
        mp3Bean = id3.readMp3File(file);

        /**
         * Speicherung der Mp3Bean in Datenbank
         */
        this.persistMp3(mp3Bean);
    }

    /**
     * Wertet den String part aus, welcher aus dem Webfrontend mitgeschickt wird
     * Sinn ist es, den Namen der Datei herauszufinden, um diesen in der Upload
     * Methode zu verwenden
     *
     * @return
     */
    private String getFileName(String part) {
        int startPos;
        int lastPos;
        String fileName;
        /**
         * Sucht nach dem ersten "=" im String part Dies ergibt die
         * Startposition zum zuschneiden des Strings
         */
        startPos = part.indexOf("=") + 1;
        /**
         * Sucht nach dem ersten "," welches vorkommt. Dies ergibt die
         * Endposition zum zuschneiden des Strings
         */
        lastPos = part.indexOf(",");

        /**
         * Schneidet den String so zu, dass nur noch der Name der Datei bleibt
         */
        fileName = part.substring(startPos, lastPos);
        System.out.println("FILENAME: " + fileName);
        return fileName;
    }
}
