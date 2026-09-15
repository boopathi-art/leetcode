class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();

        boolean[][] palindrome = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;

                if (len == 1) {
                    palindrome[i][j] = true;
                } 
                else if (len == 2) {
                    palindrome[i][j] = s.charAt(i) == s.charAt(j);
                } 
                else {
                    palindrome[i][j] =
                        s.charAt(i) == s.charAt(j) &&
                        palindrome[i + 1][j - 1];
                }
            }
        }

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];

            for (int j = i + k - 1; j < n; j++) {
                if (palindrome[i][j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j + 1]);
                }
            }
        }

        return dp[0];
    }
}