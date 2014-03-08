/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.loadbalancer.remote;

import fh.ostfalia.projekt2014.loadbalancer.LoadbalancerRemoteBean;
import fh.ostfalia.projekt2014.musicserviceremoteinterface.interfaces.Musicservice;
import javax.annotation.PostConstruct;

/**
 *
 * @author KingDCB
 */
public class Musicservice1Remote extends LoadbalancerRemoteBean {
        private Musicservice musicservice1Bean;

    public Musicservice1Remote() {
        super("localhost", "3700", "java:global/Musicservice1/MusicserviceBean");
        System.out.println("ENDELookup");
    }

    @PostConstruct
    public void initBean() {
        //Holen der entfernten Loginbean bzw. deren Stub-Objekt
        musicservice1Bean = (Musicservice) super.getObject();
    }

}
