/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice;

import javax.annotation.ManagedBean;
import ejb.MyFirstBeanRemote;
import fh.ostfalia.projekt2014.beanmanager.RemoteManagedBean;
import java.util.ArrayList;
import java.util.Collections;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
/**
 *
 * @author Yannick
 */
@ManagedBean
public class MyManagedBean extends RemoteManagedBean{
    /**
     * Creates a new instance of MyManagedBean
     */
    public MyManagedBean() {
        super("localhost", "1099", "java:global/Musicservice");
    }
    
    @PostConstruct
    public void init(){
        MyFirstBeanRemote obj = (MyFirstBeanRemote) super.getObject();
        System.out.println("TTTEESSST: "+ obj.getValue());
        //MyFirstBeanRemote object = (MyFirstBeanRemot) super.getRemoteObject();
        //cityList = new ArrayList<String> (object.getCitylist());    //hole alle Städte (Stadtplan)
        //Collections.sort(cityList);                                 //sortieren
    }
    
}
