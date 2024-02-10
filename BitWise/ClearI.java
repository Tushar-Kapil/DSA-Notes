package BitWise;

public class ClearI {

    public static void main(String[] args) {
        int a = 512;
        int i = 9;

        int mask = ~(i << 9);

        if ((a & mask) == 0) {
            System.out.println(i + "th bit is cleared");
        }
    }
}
