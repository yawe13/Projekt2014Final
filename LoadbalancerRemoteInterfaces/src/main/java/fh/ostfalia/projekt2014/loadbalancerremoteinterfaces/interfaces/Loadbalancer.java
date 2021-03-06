/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.interfaces;

import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.entities.LoadbalancerResult;
import java.util.concurrent.Future;
import javax.ejb.Asynchronous;
import javax.ejb.Remote;

/**
 *
 * @author Yannick
 */
@Remote
public interface Loadbalancer {
    
    @Asynchronous
    public Future<LoadbalancerResult> startLoadbalancerSimulation();
    
    public LoadbalancerResult startLoadbalancerSimulationByTime();
    
    @Asynchronous 
    public void stopLoadbalancerSimulation();

}
