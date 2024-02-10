package BitWise;

public class BitWise2 {

    public static void main(String[] args) {
        int a = 10 << 1;
        System.out.println(a);

        int b = 20 >> 1;
        System.out.println(b);

        boolean ans = isEven(13);
        System.out.println(ans);
    }

    static boolean isEven(int num) {
        return (num & 1) == 0;
    }
}
