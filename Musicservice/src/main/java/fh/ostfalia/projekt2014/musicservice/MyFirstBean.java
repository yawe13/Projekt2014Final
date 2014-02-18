/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice;

import ejb.MyFirstBeanRemote;
import javax.ejb.Stateful;

/**
 *
 * @author Yannick
 */
@Stateful
public class MyFirstBean implements MyFirstBeanRemote {

    @Override
    public int getValue() {
        return 5;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public String getString() {
        return "RMI GEHT!!!!!";
    }

}
