package uk.ac.cam.kjh67.q64;

import java.util.List;

interface Drawable {
    void draw();
}

abstract class Shape implements Drawable{
    public abstract void draw();
}

class Circle extends Shape {
    public void draw() {
        System.out.print("o");
    }
}

class Rectangle extends Shape {
    public void draw() {
        System.out.print("#");
    }
}


class ShapeGroup implements Drawable {
    List<Drawable> group;

    ShapeGroup(List<Drawable> drawables) {
        group = List.copyOf(drawables);
    }

    public void draw() {
        for(Drawable drawable : group) {
            drawable.draw();
        }
    }
}


// Decorator for shapes
class ShapeFrame implements Drawable {
    Shape framedShape;

    ShapeFrame(Shape shape) {
        framedShape = shape;
    }

    public void draw() {
        System.out.println("---");
        System.out.print("|");
        framedShape.draw();
        System.out.println("|");
        System.out.println("---");
    }
}


public class ShapeDrawing {
    public static void main(String[] args) {
//        PART B
//
//        List<Shape> shapes = List.of(new Circle(), new Rectangle(), new Circle());
//        for(Shape shape : shapes) {
//            shape.draw();
//        }
//        System.out.println();

        // Addition of ShapeFrame for part D
        ShapeGroup shapeGroup1 = new ShapeGroup(List.of(new ShapeFrame(new Circle()), new ShapeFrame(new Rectangle()), new ShapeFrame(new Circle())));
        ShapeGroup shapeGroup2 = new ShapeGroup(List.of(new Rectangle(), new Circle(), new Rectangle()));

        shapeGroup1.draw();
        System.out.println();
        shapeGroup2.draw();
        System.out.println();

        ShapeGroup allShapes = new ShapeGroup(List.of(shapeGroup1, shapeGroup2));
        allShapes.draw();
    }
}
