package com.tira.tehtava19202122;

import java.util.Comparator;

public class NameComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        TrafficCard t1 = (TrafficCard)o1;
        TrafficCard t2 = (TrafficCard)o2;
//        if (t1.mOwnerName.equals(t2.mOwnerName)) {
//            return 0;
//        } else if (t1.mOwnerName.compareTo(t2.mOwnerName) > 0) {
//            return 1;
//        }
//        return -1;
        return t1.mOwnerName.compareTo(t2.mOwnerName);
    }
}
