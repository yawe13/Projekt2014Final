/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loadbalancer;

import fh.ostfalia.projekt2014.loadbalancer.remote.Musicservice1Remote;
import fh.ostfalia.projekt2014.loadbalancer.remote.Musicservice2Remote;
import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.entities.LoadbalancerResult;
import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.interfaces.Loadbalancer;
import javax.ejb.Stateful;
import javax.ejb.LocalBean;

/**
 *
 * @author Yannick
 */
@Stateful
@LocalBean
public class LoadbalancerBean implements Loadbalancer{
    private Musicservice1Remote musicservice1;
    private Musicservice2Remote musicservice2;
    
    @Override
    public LoadbalancerResult startLoadbalancerSimulation() {
        
        return null;
        
    }
}
