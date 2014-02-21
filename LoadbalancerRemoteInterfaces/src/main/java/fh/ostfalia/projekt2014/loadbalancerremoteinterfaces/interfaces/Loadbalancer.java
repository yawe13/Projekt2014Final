/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.interfaces;

import javax.ejb.Remote;

/**
 *
 * @author Yannick
 */
@Remote
public interface Loadbalancer {
    
    public void callMusicservice(String musicservice);
}
