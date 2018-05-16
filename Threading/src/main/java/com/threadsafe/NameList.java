package com.threadsafe;

import java.util.*;

public class NameList {
    private List names = Collections.synchronizedList(
            new LinkedList());

    public synchronized void add(String name) {
        names.add(name);
    }

    public synchronized String removeFirst() {
        if (names.size() > 0)
            return (String) names.remove(0);
        else
            return null;
    }
}
