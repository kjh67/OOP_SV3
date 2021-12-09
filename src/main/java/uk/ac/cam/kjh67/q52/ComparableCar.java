package uk.ac.cam.kjh67.q52;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableCar implements Comparable<ComparableCar>{
    private String manufacturer;
    private int age;

    ComparableCar(String manufacturer, int age) {
        this.manufacturer = manufacturer;
        this.age = age;
    }

    public String getManufacturer() { return manufacturer; }

    @Override
    public String toString() {
        return String.format("%s year old %s", age, manufacturer);
    }

    @Override
    public int compareTo(ComparableCar c) {
        int to_return = this.manufacturer.compareTo(c.manufacturer);
        if (to_return == 0) {
            to_return = ((Integer)this.age).compareTo((Integer)c.age);
        }
        return to_return;
    }

    public static void main(String[] args) {
        ArrayList<ComparableCar> cars = new ArrayList<>();
        cars.add(new ComparableCar("Vauxhall", 7));
        cars.add(new ComparableCar("Audi", 11));
        cars.add(new ComparableCar("Subaru", 25));
        cars.add(new ComparableCar("Ford", 3));
        cars.add(new ComparableCar("Ford", 1));

        Collections.sort(cars);
        System.out.println(cars);

        // Output is:
        // [11 year old Audi, 1 year old Ford, 3 year old Ford, 25 year old Subaru, 7 year old Vauxhall]
    }
}
