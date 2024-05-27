package BitWise;

public class ClearI {

    public static void main(String[] args) {
        int a = 13;
        int i = 2;

        int mask = ~(1 << i);

        if ((a & mask) == 0) {
            System.out.println(i + "th bit is cleared");
        }
    }
}
