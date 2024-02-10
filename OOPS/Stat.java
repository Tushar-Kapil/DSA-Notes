package OOPS;

class Human {
    int age;
    String name;

    static int population = 0;

    Human(int age, String name) {
        this.age = age;
        this.name = name;

        population++;
    }
}

public class Stat {

    public static void main(String[] args) {
        Human h1 = new Human(18, "Tushar");
        Human h2 = new Human(35, "Rajesh");

        System.out.println(h1.name);
        System.out.println(h2.name);

        System.out.println(Human.population);

    }
}
