/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.musicserviceremoteinterface.interfaces;

import fh.ostfalia.projekt2014.musicserviceremoteinterface.entities.Mp3;
import java.util.List;
import javax.ejb.Remote;



/**
 *
 * @author Mettbrötchen
 */
@Remote
public interface Musicservice {
   
    
    public List<Mp3> getAllMp3s();
    public Mp3 getMp3(int mp3Id); 
    
    public String getPassedParameter();
    public void upload();
}
