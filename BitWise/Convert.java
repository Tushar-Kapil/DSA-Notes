package BitWise;

public class Convert {
    public static void main(String[] args) {
        System.out.println(toBin(13));
        System.err.println(toDec("101"));
        System.out.println(13 >> 1);
    }

    public static String toBin(int n) {
        StringBuilder res = new StringBuilder("");

        while (n != 0) {
            if (n % 2 == 1) {
                res.append("1");
            } else {
                res.append("0");
            }

            n = n / 2;
        }

        return res.reverse().toString();
    }

    public static int toDec(String num) {
        int ind = num.length() - 1;
        int pow = 1;
        int ans = 0;

        for (int i = ind; i >= 0; i--) {
            if (num.charAt(i) == '1') {
                ans = ans + pow;
            }
            pow = pow * 2;
        }

        return ans;
    }

}
