/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.entities;

import java.util.Map;

/**
 *
 * @author KingDCB
 */
public interface LoadbalancerResult {
    public Map<Integer, Integer> getMyMap();
    public void setMyMap(Map<Integer, Integer> myMap);
}
