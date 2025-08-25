import java.util.HashMap;

public class App {
    public static HashMap <Integer, Integer> memo = new HashMap<>();
    public static int cutRodDP(int[] p, int n){
        int[] dp = new int[n + 1]; // dp[j] holds the maximum revenue for rod length j
        dp[0] = 0; // base case: no rod, no revenue

        // Build up the solution for rod lengths from 1 to n
        for (int j = 1; j <= n; j++) {
            int maxRevenue = Integer.MIN_VALUE;
            // Try every possible first cut i (only if price exists for that cut)
            for (int i = 1; i <= j; i++) {
                if (i <= p.length) {
                    maxRevenue = Math.max(maxRevenue, p[i - 1] + dp[j - i]);
                }
            }
            dp[j] = maxRevenue;
        }
        return dp[n];
    }
    public static void main(String[] args) throws Exception {
        int[] prices = {1, 5, 8, 9}; 
        int n = 4; 

        System.out.println("Maximum Revenue: " + cutRodDP(prices, n));
    }
}
