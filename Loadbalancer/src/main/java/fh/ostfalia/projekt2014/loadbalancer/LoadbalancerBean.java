/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loadbalancer;

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

    @Override
    public void callMusicservice(String musicservice) {
        
    }
    
    
    
}
