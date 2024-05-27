package BitWise;

public class SetI {

    public static void main(String[] args) {
        int a = 309;
        int i = 3;

        int mask = 1 << i;

        if ((a | mask) != 0) {
            System.out.println(i + "th bit is set");
        }
    }
}
