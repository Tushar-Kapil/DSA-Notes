package OOPS;

interface Engine {

    int PRICE = 780000;

    void start();

    void stop();

    void acc();
}

interface Media {
    void start();

    void stop();
}

class Car implements Engine, Media {

    @Override
    public void start() {
        System.out.println("Car is started");
    }

    @Override
    public void stop() {
        System.out.println("Car is Stopped");

    }

    @Override
    public void acc() {
        System.out.println("Car is Accelerated");

    }

}

public class Inter {

    public static void main(String[] args) {
        Engine c = new Car();
        c.start();
        c.stop();
        c.acc();
    }
}
