package Strings;

public class Strings {

    public static void main(String[] args) {

        // String Pooling
        // Immutability

        // String a = "Tushar";
        // String b = "Tushar";

        // a = "Tusharr"; // creates a new obj

        // System.out.println(a);
        // System.out.println(b);

        // System.out.println(a == b); // checks reference and value

        String n1 = new String("Tushar");
        String n2 = new String("Tushar"); // Creating outside pool different objects

        System.out.println(n1 == n2);

        System.out.println(n1.equals(n2)); // checks only value

    }
}
