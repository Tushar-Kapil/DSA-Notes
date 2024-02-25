package DynamicProgramming.Strings;

public class WildCard {

    Boolean dp[][];

    public boolean isMatch(String s, String p) {
        int m = p.length();
        int n = s.length();

        dp = new Boolean[m][n];

        return is_match(m - 1, n - 1, p, s);
    }

    private boolean is_match(int m, int n, String p, String s) {
        if (m < 0 && n < 0)
            return true;

        if (m < 0 && n >= 0)
            return false;

        if (n < 0 && m >= 0) {
            for (int i = 0; i <= m; i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        }

        if (dp[m][n] != null)
            return dp[m][n];

        if (p.charAt(m) == s.charAt(n) || p.charAt(m) == '?') {
            return dp[m][n] = is_match(m - 1, n - 1, p, s);
        }

        if (p.charAt(m) == '*') {
            return dp[m][n] = is_match(m - 1, n, p, s) || is_match(m, n - 1, p, s);
        }

        return false;
    }
}
