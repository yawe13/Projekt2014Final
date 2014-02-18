/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musikdienst;

import ejb.MyFirstRemoteBeanRemote;
import javax.ejb.Stateful;

/**
 *
 * @author Yannick
 */
@Stateful
public class MyFirstRemoteBean implements MyFirstRemoteBeanRemote {

    @Override
    public int getValue() {
        return 5;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
