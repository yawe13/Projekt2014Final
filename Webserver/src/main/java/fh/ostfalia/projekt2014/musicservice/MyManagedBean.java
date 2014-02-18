/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice;


import ejb.MyFirstBeanRemote;
import fh.ostfalia.projekt2014.beanmanager.RemoteManagedBean;
import javax.annotation.PostConstruct;

/**
 *
 * @author Yannick
 */

public class MyManagedBean extends RemoteManagedBean{
    /**
     * Creates a new instance of MyManagedBean
     */
    public MyManagedBean() {
        super("localhost", "3700", "java:global/Musicservice/MyFirstBean");
    }
    
    public void getString(){
        System.out.println("StartTest....");
        MyFirstBeanRemote obj = (MyFirstBeanRemote) super.getObject();
        System.out.println("TEST " + obj.getString());
    }
    
    @PostConstruct
    public void init(){
        //MyFirstBeanRemote obj = (MyFirstBeanRemote) super.getObject();
        //System.out.println("TTTEESSST: "+ obj.getValue());
        //MyFirstBeanRemote object = (MyFirstBeanRemot) super.getRemoteObject();
        //cityList = new ArrayList<String> (object.getCitylist());    //hole alle Städte (Stadtplan)
        //Collections.sort(cityList);                                 //sortieren
    }
    

    
}
