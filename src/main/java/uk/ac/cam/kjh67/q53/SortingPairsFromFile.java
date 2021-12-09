package uk.ac.cam.kjh67.q53;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class IntegerPair implements Comparable<IntegerPair>{
    private int first;
    private int second;

    IntegerPair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {return first;}
    public int getSecond() {return second;}

    @Override
    public int compareTo(IntegerPair p) {
        if (first < p.first || (first==p.first && second<p.second)) {
            return -1;
        }
        else if (first==p.first && second==p.second) {
            return 0;
        }
        return 1;
    }
}


public class SortingPairsFromFile {

    public static void main(String[] args) {
//        try(Scanner fileScanner = new Scanner(new File(
//                "C:\\Users\\kirst\\Documents\\Cambridge\\OOP\\SV3\\src\\main\\java\\uk\\ac\\cam\\kjh67\\q53\\CSVPairs.csv"))) {
//        }

//        try(BufferedReader br = new BufferedReader(new FileReader("CSVPairs.csv"))) {
//            System.out.println("yes");
//
//        }

        // Aim to get a list of pairs from the file - this is a temporary substitute
        ArrayList<IntegerPair> pairs = new java.util.ArrayList<>(List.of(new IntegerPair(1, 2), new IntegerPair(3, 3), new IntegerPair(3, 1), new IntegerPair(1, 1), new IntegerPair(1, 2)));

        Collections.sort(pairs);

        for(IntegerPair pair : pairs) {
            System.out.println(String.format("%s,%s", pair.getFirst(), pair.getSecond()));
        }
    }
}
