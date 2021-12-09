package uk.ac.cam.kjh67.q50;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.awt.*;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.TreeSet;

@RunWith(JUnit4.class)
public class Point3DTests {

    @Test
    public void point3D_instantiatesCorrectly() {
        Point3D point = new Point3D(0,0,0);
        assertThat(point.toString()).isEqualTo("[0.0,0.0,0.0]");
    }

    @Test
    public void point3D_orderingBy_zOnly() {
        Point3D point1 = new Point3D(1,2,3);
        Point3D point2 = new Point3D(1,2,2);

        TreeSet<Point3D> sorted = new TreeSet<>();
        sorted.add(point1);
        sorted.add(point2);

        assertThat(sorted.toString()).isEqualTo(String.format("[%s, %s]", point2.toString(), point1.toString()));
    }

    @Test
    public void point3D_orderingBy_yOnly() {
        Point3D point1 = new Point3D(1,4,3);
        Point3D point2 = new Point3D(1,2,3);

        TreeSet<Point3D> sorted = new TreeSet<>();
        sorted.add(point1);
        sorted.add(point2);

        assertThat(sorted.toString()).isEqualTo(String.format("[%s, %s]", point2.toString(), point1.toString()));
    }

    @Test
    public void point3D_orderingBy_xOnly() {
        Point3D point1 = new Point3D(1,2,3);
        Point3D point2 = new Point3D(0,2,3);

        TreeSet<Point3D> sorted = new TreeSet<>();
        sorted.add(point1);
        sorted.add(point2);

        assertThat(sorted.toString()).isEqualTo(String.format("[%s, %s]", point2.toString(), point1.toString()));
    }
}
