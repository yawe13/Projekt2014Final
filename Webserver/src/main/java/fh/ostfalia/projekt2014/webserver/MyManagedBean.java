/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.webserver;

import javax.annotation.ManagedBean;
import ejb.MyFirstRemoteBeanRemote;
import javax.ejb.EJB;
/**
 *
 * @author Yannick
 */
@ManagedBean
public class MyManagedBean {

    /**
     * Creates a new instance of MyManagedBean
     */
    public MyManagedBean() {
        @EJB
        MyFirstRemoteBean mb;
    }
}
