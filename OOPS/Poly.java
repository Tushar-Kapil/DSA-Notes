package OOPS;

class Shapes {
    void area() {
        System.out.println("In shaped");
    }
}

class Circle extends Shapes {
    void area() {
        System.out.println("Area of circle");
    }
}

class Triangle extends Shapes {
    void area() {
        System.out.println("Area of Triangle");
    }
}

public class Poly {

    public static void main(String[] args) {
        Shapes c1 = new Circle();
        c1.area();

        // Types
        // 1) Static Poly / Compile time --> achieved via method overloading
        // 2) Dynamic poly / Runtime ==> over ridding
    }
}
