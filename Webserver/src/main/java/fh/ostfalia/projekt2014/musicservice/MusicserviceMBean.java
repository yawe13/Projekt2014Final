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
    List<Mp3> mp3List;
    List<Mp3BeanClient> mp3BeanClientList;
   
   
    private Mp3BeanClient mp3MBean;

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
    public void upload() {
        musicserviceBean.upload();
    }

    @Override
    public String getPassedParameter() {
        return musicserviceBean.getPassedParameter();
    }

    @Override
    public Mp3 getMp3(int mp3Id) {
        return musicserviceBean.getMp3(mp3Id);
    }
    

   
    public List<Mp3BeanClient> getAllMp3BeansRemote() {
        mp3List = musicserviceBean.getAllMp3s();
        
       
        for(int i=0;i<=mp3List.size();i++){
            mp3BeanClientList.add((Mp3BeanClient) mp3List.get(i));
          
        }
        return mp3BeanClientList;
    }

    @Override
    public List<Mp3> getAllMp3s() {
        return null;
    }

 
}
