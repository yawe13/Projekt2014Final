/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.musicserviceremoteinterface.entities;

import java.io.File;

/**
 *
 * @author Mettbrötchen
 */
public interface Mp3 {
     public int getMp3Id();
     public void setMp3Id(int mp3_id);
     public byte[] getMp3File();
     public void setMp3File(byte[] mp3_file);
     public String getMp3Title();
     public void setMp3Title(String mp3_title);
     public int getArtistId();
     public void setMp3ByteCodeFromFile(File file);
             
     
}
