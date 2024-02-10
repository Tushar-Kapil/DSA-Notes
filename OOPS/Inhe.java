package OOPS;

class Parent {
    int money;

    int hieght;

    Parent(int money, int hieght) {
        this.money = money;
        this.hieght = hieght;
    }

}

class Child extends Parent {
    String car;

    Child(int money, int hieght, String car) {
        super(money, hieght);
        this.car = car;
    }
}

public class Inhe {

    public static void main(String[] args) {
        Child ch = new Child(10000, 6, "BMW");

        Parent pa = new Child(5000000, 5, "Audi");
        System.out.println(pa);
        // Child pa = new Parent(5000000, 5);

        // System.out.println(pa.car);

        System.out.println(ch.money);

        // Types of inheritance
        // 1) Single Inheritance
        // 2) Multilevel Inheritance
        // 3) Multiple Inheritance (Amuguity) --> not allowed in java
        // 4) Hierarchical Inheritance --> one class is extended by many classes
        // 5) Hybrid Inheritance --> Combination of single and multiple (Not allowed
        // java)
    }
}
