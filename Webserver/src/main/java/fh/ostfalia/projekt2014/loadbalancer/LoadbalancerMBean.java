/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loadbalancer;

import fh.ostfalia.projekt2014.beanmanager.RemoteManagedBean;
import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.entities.LoadbalancerResult;
import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.interfaces.Loadbalancer;
import javax.annotation.PostConstruct;

/**
 *
 * @author Yannick
 */
public class LoadbalancerMBean extends RemoteManagedBean{
    private Loadbalancer loadbalancerBean;
    private LoadbalancerResult loadbalancerResult;
    
    public LoadbalancerMBean() {
         super("localhost", "3700", "java:global/Loadbalancer/LoadbalancerBean");
    }
    
     @PostConstruct
    public void initBean() {
        //Holen der entfernten LoadbalancerBean bzw. deren Stub-Objekt
       loadbalancerBean = (Loadbalancer) super.getObject();
    }
    
    public void startLoadbalancerSimulation(){
//        this.loadbalancerResult = loadbalancerBean.startLoadbalancerSimulation();
        loadbalancerResult.getServerId();
    }
}
