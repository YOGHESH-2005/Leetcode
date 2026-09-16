
class Solution {
    public int numberOfSets(int n, int k) {
        final int mod = 1000000007;
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
        for (int segments = 1; segments <= k; segments++) {
            long[] next = new long[n];
            long prefix = 0;
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    prefix += dp[i - 1];
                    if (prefix >= mod) {
                        prefix -= mod;
                    }
                }
                next[i] = (i > 0 ? next[i - 1] : 0);
                next[i] += prefix;
                if (next[i] >= mod) {
                    next[i] -= mod;
                }
            }
            dp = next;
        }
        return (int) dp[n - 1];
    }
}