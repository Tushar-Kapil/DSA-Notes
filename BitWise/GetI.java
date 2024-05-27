package BitWise;

public class GetI {

    public static void main(String[] args) {

        int a = 308;
        int i = 3;
        int mask = 1 << i;

        if ((a & mask) != 0) {
            System.out.println(i + "th bit is 1");
        } else {
            System.out.println(i + "th bit is 0");
        }
    }
}
