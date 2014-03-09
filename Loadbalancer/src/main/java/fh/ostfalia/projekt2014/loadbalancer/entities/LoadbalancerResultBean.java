/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fh.ostfalia.projekt2014.loadbalancer.entities;

import fh.ostfalia.projekt2014.loadbalancerremoteinterfaces.entities.LoadbalancerResult;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author KingDCB
 */
public class LoadbalancerResultBean implements LoadbalancerResult{
 
   //enthält ServerId + Anzahl der Aufrufe auf diese ID
    private Map<Integer,Integer> simulationMap = new HashMap<>();

    public LoadbalancerResultBean(Map<Integer,Integer> simulationMap) {
        this.simulationMap = simulationMap;
    }
    @Override
    public Map<Integer, Integer> getMyMap() {
        return simulationMap;
    }
    @Override
    public void setMyMap(Map<Integer, Integer> myMap) {
        this.simulationMap = myMap;
    }
      
}
