package uk.ac.cam.kjh67.q47;

import java.util.Arrays;
import java.util.Iterator;

public class AveragingIntegers {

    // For-loop implementation
    public static double averageWithForLoop(int[] intlist) {
        double total = 0;
        for (int i=0; i < intlist.length; i++) {
            total += intlist[i];
        }
        return total / intlist.length;
    }

    // For-each loop implementation
    public static double averageWithForEachLoop(int[] intlist) {
        double total = 0;
        for (int i: intlist) {
            total += i;
        }
        return total / intlist.length;
    }

    // Iterator implementation
    public static double averageWithIterator(int[] intlist) {
        Iterator<Integer> iter = Arrays.stream(intlist).iterator();
        double total = 0;
        while (iter.hasNext()) {
            total += iter.next();
        }
        return total/intlist.length;
    }

    public static void main(String[] args) {
        int[] intlist = {1,2,3,4,5};

        System.out.println(averageWithForLoop(intlist));
        System.out.println(averageWithForEachLoop(intlist));
        System.out.println(averageWithIterator(intlist));
    }
}
