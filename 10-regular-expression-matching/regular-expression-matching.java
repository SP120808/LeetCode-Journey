
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        dp[0][0] = true;

        for (int j = 2; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        }

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                char a = s.charAt(i - 1);
                char b = p.charAt(j - 1);

                if (b == '.' || a == b)
                    dp[i][j] = dp[i - 1][j - 1];

                else if (b == '*') {
                    dp[i][j] = dp[i][j - 2];

                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == a)
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
