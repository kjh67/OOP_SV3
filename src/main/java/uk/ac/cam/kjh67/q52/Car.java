package uk.ac.cam.kjh67.q52;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Car{
    private String manufacturer;
    private int age;

    Car(String manufacturer, int age) {
        this.manufacturer = manufacturer;
        this.age = age;
    }

    public String getManufacturer() { return manufacturer; }

    @Override
    public String toString() {
        return String.format("%s year old %s", age, manufacturer);
    }

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("Vauxhall", 7));
        cars.add(new Car("Audi", 11));
        cars.add(new Car("Subaru", 25));
        cars.add(new Car("Ford", 3));
        cars.add(new Car("Ford", 1));

        Collections.sort(cars, Comparator.comparing(c -> c.manufacturer));
        // equivalent expression to comparator: (c1,c2)->(c1.manufacturer.compareTo(c2.manufacturer))
        System.out.println(cars);

        // Output is:
        // [11 year old Audi, 3 year old Ford, 1 year old Ford, 25 year old Subaru, 7 year old Vauxhall]
    }
}
