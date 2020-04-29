package com.tira.tehtava19202122;

import java.util.Comparator;

public class BalanceComparator implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        TrafficCard t1 = (TrafficCard)o1;
        TrafficCard t2 = (TrafficCard)o2;
//        if (t1.mBalance == t2.mBalance) {
//            return 0;
//        } else if (t1.mBalance > t2.mBalance) {
//            return 1;
//        }
//        return -1;
        return (int)(t1.mBalance - t2.mBalance);
    }
}
