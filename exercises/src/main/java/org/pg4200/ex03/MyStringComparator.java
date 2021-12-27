package org.pg4200.ex03;

import java.util.Comparator;

public class MyStringComparator implements Comparator<String> {

    //        Returns positive number if sorted alphabetically
    //        Returns 0 if equal
    //        Returns negative if not sorted

    @Override
    public int compare(String a, String b) {
        int result = a.compareTo(b);
        return result;
    }

}
