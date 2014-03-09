/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loadbalancer;

import fh.ostfalia.projekt2014.loadbalancer.entities.LoadbalancerResultBean;
import fh.ostfalia.projekt2014.loadbalancer.remote.Musicservice1Remote;
import fh.ostfalia.projekt2014.loadbalancer.remote.Musicservice2Remote;
import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.entities.LoadbalancerResult;
import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.interfaces.Loadbalancer;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.interfaces.Musicservice;
import java.util.HashMap;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.Stateful;


/**
 *
 * @author Yannick
 */
@Stateful
public class LoadbalancerBean implements Loadbalancer{
    

    
    private AsyncResult <LoadbalancerResult> asyncresult;
    private int requests;
    private Musicservice targetMusicService;
    
    private boolean status = false;
    
    @Override
    @Asynchronous
    public Future<LoadbalancerResult> startLoadbalancerSimulation() {
             
        status = true;
        while (status){
                 System.out.println(status);
                 requests = (int)((Math.random()*20)+1);
                 for(int i =0; i<requests; i++){
                     try {
                         System.out.println("Rufe irgendwas auf");
                         Thread.sleep(1000);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(LoadbalancerBean.class.getName()).log(Level.SEVERE, null, ex);
                     }
                 }
                 System.out.println("Anzahl der Aufrufe: " + requests);
        }
    
        

        LoadbalancerResult loadbalancerResult = new LoadbalancerResultBean(new HashMap(1,requests));
        asyncresult = new AsyncResult <>(loadbalancerResult);
        return asyncresult;
    }

    @Override
    public LoadbalancerResult startLoadbalancerSimulationByTime() {
        System.out.println("ich laufe parallel :)");
        return null;
    }
    @Override 
    @Asynchronous 
    public void stopLoadbalancerSimulation(){
        System.out.println("stoppe Simlation");
        status = false;
        System.out.println(status);
  
        //Versuche zu unterbrechen
      
       
        
    }
    
    
}
