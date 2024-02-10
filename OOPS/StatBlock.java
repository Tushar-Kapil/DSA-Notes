package OOPS;

public class StatBlock {

    static int a = 4;

    static int b;

    // runs only once
    static {
        System.out.println("In static");

        b = a * 4;
    }

    public static void main(String[] args) {
        // StatBlock sb1 = new StatBlock();

        System.out.println(StatBlock.a + " " + StatBlock.b);

        StatBlock.b += 3;
        System.out.println(StatBlock.a + " " + StatBlock.b);

        // StatBlock sb2 = new StatBlock();
        System.out.println(StatBlock.a + " " + StatBlock.b);

    }
}
