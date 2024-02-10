package OOPS;

public class Inner {

    static class A {

        String name;

        A(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        A a = new A("Tushar");

        System.out.println(a.name);

    }

}
