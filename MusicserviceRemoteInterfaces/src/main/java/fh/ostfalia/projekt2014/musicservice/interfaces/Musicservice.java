/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fh.ostfalia.projekt2014.musicservice.interfaces;

import fh.ostfalia.projekt2014.musicservice.entities.Mp3Song;
import java.util.List;
import javax.ejb.Remote;

/**
 * Remoteinterface zum Aufruf des Musikdienstes.
 * Methoden dieses Interfaces werden vom User in der Präsentationsschicht, d.h. aus den entsprechenden Seiten in aufgerufen. 
 * Die Aufrufe gehen allerdings nicht direkt auf den Musikdienst, sondern laufen über den Loadbalancer, der entsprechend der Lastvorkommnisse
 * auf den Musikservern die Anfragen an den Musikserver 1 oder Musikserver 2 weiterleitet.
 * Dazu implementiert der Loadbalancer das Interface des Musikdienstes und leitet dementsprechend die Aufrufe des Users aus der Präsentationsschicht den Musikdienst weiter. 
 * @author Yannick
 */
@Remote
public interface Musicservice {

    public Mp3Song getMp3Song();
}
