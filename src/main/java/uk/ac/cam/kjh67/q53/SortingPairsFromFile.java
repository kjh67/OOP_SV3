package uk.ac.cam.kjh67.q53;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

//
// FILE READING WORKS NOW :D (needed to specify the file path starting from src)
//

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
        ArrayList<IntegerPair> pairs = new ArrayList<>();

        try(BufferedReader fileReader = new BufferedReader(new FileReader(
                "src/main/java/uk/ac/cam/kjh67/q53/CSVPairs.csv")))
        {
            String line = "";
            while((line=fileReader.readLine()) != null) {
                String[] pairAsString = line.split(",");
                pairs.add(new IntegerPair(
                        Integer.parseInt(pairAsString[0]),
                        Integer.parseInt(pairAsString[1]))
                );
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        // List to sort while file read wasn't working
        // ArrayList<IntegerPair> pairs = new java.util.ArrayList<>(List.of(new IntegerPair(1, 2), new IntegerPair(3, 3), new IntegerPair(3, 1), new IntegerPair(1, 1), new IntegerPair(1, 2)));

        Collections.sort(pairs);
        for(IntegerPair pair : pairs) {
            System.out.println(String.format("%s,%s", pair.getFirst(), pair.getSecond()));
        }
    }
}
