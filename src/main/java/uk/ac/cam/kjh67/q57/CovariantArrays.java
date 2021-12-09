package uk.ac.cam.kjh67.q57;

public class CovariantArrays {
    public static void main(String[] args) {
        Integer[] ints = {1,2,3,4};

        Object[] objects = ints;

        objects[0] = "Hi";
    }
}