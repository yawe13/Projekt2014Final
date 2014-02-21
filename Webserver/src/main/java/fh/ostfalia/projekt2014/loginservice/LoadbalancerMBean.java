/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.loginservice;

import fh.ostfalia.projekt2014.beanmanager.RemoteManagedBean;

/**
 *
 * @author Yannick
 */
public class LoadbalancerMBean extends RemoteManagedBean{

    public LoadbalancerMBean() {
         super("localhost", "3700", "java:global/Loadbalancer/LoginBean");
    }
}
