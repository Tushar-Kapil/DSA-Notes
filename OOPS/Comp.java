package OOPS;

class Engine {

    void work() {
        System.out.println("Engine started");
    }
}

class Car {
    Engine engine;

    Car() {
        this.engine = new Engine();
    }

    public void move() {
        engine.work();
    }
}

public class Comp {
    public static void main(String[] args) {
        Car bmw = new Car();
        bmw.move();
    }
}
