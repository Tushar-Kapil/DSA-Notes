package OOPS;

abstract class Parent {
    abstract void carrer(String name);

    abstract void partener(String name);

    static void greet() {
        System.out.println("Hello");
    }
}

class Son extends Parent {

    @Override
    public void carrer(String name) {
        System.out.println("I am " + name);
    }

    @Override
    void partener(String name) {
        System.out.println("My partner is " + name);
    }

}

public class Abstrac {

    public static void main(String[] args) {
        Son s = new Son();
        s.carrer("SDE");
        Parent.greet();
    }
}
