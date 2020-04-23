/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tira.tehtava19202122;

import java.util.*;
/**
 *
 * @author kamaj
 */
public class UsingJCAPI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<TrafficCard> cardUsers = new ArrayList<>();
        RandomString rString = new RandomString(10);
        float genBalance;
        TrafficCard myCard;
        Random r = new Random();
        int i;
        for (i = 0; i < 10; i++) {
            genBalance = ((float) r.nextInt(1000) / 10);
            myCard = new TrafficCard(r.nextInt(100), rString.nextString(), genBalance);
            cardUsers.add(myCard);
        }

        System.out.println("Travel cards on collection");
        Iterator itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println();

        // tehtävä 19
        System.out.println("Travel cards sorted by balance using TrafficCard compare()");
        Collections.sort(cardUsers);
        itr = cardUsers.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println();

        // tehtävä 20
        System.out.println("Travel cards sorted by owner name using NameComparator");
        Collections.sort(cardUsers, new NameComparator());
        itr = cardUsers.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println();

        System.out.println("Travel cards sorted by balance using BalanceComparator");
        Collections.sort(cardUsers, new BalanceComparator());
        itr = cardUsers.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println();

        // tehtävä 21
        System.out.println("Travel cards sorted by traveller number using lambda");
        Collections.sort(cardUsers, (o1, o2) ->{
            TrafficCard t1 = (TrafficCard)o1;
            TrafficCard t2 = (TrafficCard)o2;
            return t1.mTravellerNumber - t2.mTravellerNumber;
        });
        itr = cardUsers.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println();

        // tehtävä 22
        System.out.println("Travel cards with traveller number between 20 & 55 and balance below 50");
        cardUsers
                .stream()
                .filter(t -> t.mTravellerNumber >= 20 && t.mTravellerNumber <= 55)
                .filter(t -> t.mBalance < 50)
                .sorted(new NameComparator())
                .forEach(e -> System.out.println(e.toString()));

    }
}
