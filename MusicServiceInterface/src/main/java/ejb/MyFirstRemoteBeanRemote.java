/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Remote;

/**
 *
 * @author Yannick
 */
@Remote
public interface MyFirstRemoteBeanRemote {
    public int getValue();
}
