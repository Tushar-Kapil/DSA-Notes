package BitWise;

public class NumToZ {

    public static void main(String[] args) {
        int a = 13;
        int count = 0;

        while (a != 0) {
            count++;
            a = a & (a - 1);
        }
        System.out.println(count);
    }
}
