/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loadbalancer;

import fh.ostfalia.projekt2014.loadbalancer.remote.Musicservice1Remote;
import fh.ostfalia.projekt2014.loadbalancer.remote.Musicservice2Remote;
import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.entities.LoadbalancerResult;
import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.interfaces.Loadbalancer;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.interfaces.Musicservice;
import javax.ejb.EJB;
import javax.ejb.Stateful;


/**
 *
 * @author Yannick
 */
@Stateful
public class LoadbalancerBean implements Loadbalancer{
    

    public LoadbalancerResult loadbalancerResult;
   
    private int requests;
    private Musicservice targetMusicService;
    
    @Override
    public LoadbalancerResult startLoadbalancerSimulation() {
        requests = (int)((Math.random()*20)+1);
        System.out.println("Anzahl der Aufrufe: " + requests);
   
        return null;  
    }

    @Override
    public LoadbalancerResult startLoadbalancerSimulationByTime() {
        return null;
    }
    
    
}
