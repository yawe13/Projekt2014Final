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
import java.util.concurrent.ExecutionException;
import javax.jms.Queue;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 *
 * @author Yannick
 */
@Stateless
public class LoadbalancerBean implements Loadbalancer{
    

    
    
    private int requests;
    private Musicservice targetMusicService;
    private LoadbalancerResult lbR;
    private boolean status = true;
    int time;
    Future <LoadbalancerResult> asyncresult = null;;
    
    @Override
    public LoadbalancerResult startLoadbalancerSimulation(){
        //Starte das Loadbalancing und speichere das Ergebnis in asyncresult
        Future <LoadbalancerResult> asyncresult = null;;
        while(status == true){
            asyncresult = runSimulation();
        }
        
        try {
            //Hole das Ergebnis des Loadbalancing
            lbR = asyncresult.get();
        } catch (InterruptedException ex) {
            Logger.getLogger(LoadbalancerBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(LoadbalancerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lbR;
    }
    
    
    @Asynchronous
    public Future<LoadbalancerResult> runSimulation() {
        requests = 10;
        LoadbalancerResult loadbalancerResult = new LoadbalancerResultBean(new HashMap(1,requests));
 
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
        

        return new AsyncResult <>(loadbalancerResult);
    }

    @Override
    public LoadbalancerResult startLoadbalancerSimulationByTime(int time) {
        System.out.println("Zeit:" + time);     
        for (long stop=System.nanoTime()+TimeUnit.SECONDS.toNanos(time);stop>System.nanoTime();){
                 System.out.println("Systemzeit:" + System.nanoTime());
                 System.out.println("Bis:" + stop);
                 System.out.println("Differenz:");
                 System.out.println(System.nanoTime()-stop);
                 try {
                     Thread.sleep(500);
                     System.out.println("tessssstttttt");
                 } catch (InterruptedException ex) {
                     Logger.getLogger(LoadbalancerBean.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }
             System.out.println("Zeit abgelaufen");
        
        return null;
    }
    
    
    @Override  
    public void stopLoadbalancerSimulation(){
        asyncresult.cancel(true);
        status = false;
        System.out.println("stoppe Simlation");
        System.out.println(status);
 
        //Versuche zu unterbrechen
    }
 
  
}
