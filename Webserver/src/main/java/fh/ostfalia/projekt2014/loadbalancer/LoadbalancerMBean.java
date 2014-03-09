/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loadbalancer;

import fh.ostfalia.projekt2014.beanmanager.RemoteManagedBean;
import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.entities.LoadbalancerResult;
import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.interfaces.Loadbalancer;
import java.util.concurrent.Future;
import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Yannick
 */
public class LoadbalancerMBean extends RemoteManagedBean{
    private Loadbalancer loadbalancerBean;
    private LoadbalancerResult loadbalancerResult;
    private Future asyncResult;
    //Variable die zwischen manuellem starten und stoppen des LB oder per definiertem Zeitintervall unterscheidet 
    //möglich sind manuel oder timed
    private String mode;
    
    public LoadbalancerMBean() {
         super("localhost", "3700", "java:global/Webserver/LoadbalancerBean");
    }
   
    
     @PostConstruct
    public void initBean() {
        //Holen der entfernten LoadbalancerBean bzw. deren Stub-Objekt
       loadbalancerBean = (Loadbalancer) super.getObject();
    }
    public String getModePage(){
        System.out.println(mode);
        if(mode.equals("manual")){
            
            return "manual";
        }
        else if(mode.equals("timed")){
            return "timed";
        }
        else{
            System.out.println("wrong Page!");
            return null;
        }

    }
    public void startLoadbalancerSimulation(){
        asyncResult = loadbalancerBean.startLoadbalancerSimulation();
        
    }
    
    public void stopLoadbalancerSimulation(){
        asyncResult.cancel(true);
       
    }
     
     public void startLoadbalancerSimulationByTime(int seconds){
        
    }
    
      public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
    
}

