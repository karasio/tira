/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tira.tehtava19202122;

/**
 *
 * @author kamaj
 */
public class TrafficCard implements Comparable{
    int mTravellerNumber;
    String mOwnerName;
    float mBalance;
    
    public TrafficCard(int tNumber, String oName, float balance){
        mTravellerNumber = tNumber;
        mOwnerName = oName;
        mBalance = balance;
    }
    
    @Override
    public String toString(){
        return "owner: "+mOwnerName+" number: "+mTravellerNumber+" balance: "+mBalance;
    }

    // tehtävä 19
    @Override
    public int compareTo(Object o) {
        TrafficCard c = (TrafficCard)o;
        if (mBalance == c.mBalance) {
            return 0;
        } else if (mBalance > c.mBalance) {
            return 1;
        } else {
            return -1;
        }
    }
}
