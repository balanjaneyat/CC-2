public class MinCostConnectGroups {

    public static int connectTwoGroups(int[][] cost) {
        int m = cost.length, n = cost[0].length;

        // Step 1: Precompute minimum cost to connect any group1 point to group2[j]
        int[] minRight = new int[n];
        for (int j = 0; j < n; j++) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                min = Math.min(min, cost[i][j]);
            }
            minRight[j] = min;
        }

        // Step 2: Initialize DP table
        int[][] dp = new int[m + 1][1 << n];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = Integer.MAX_VALUE / 2; // avoid overflow
            }
        }
        dp[0][0] = 0;
        
        // Step 3: DP state transitions
        for (int i = 1; i <= m; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                for (int j = 0; j < n; j++) {
                    int newMask = mask | (1 << j);
                    dp[i][newMask] = Math.min(dp[i][newMask],
                            dp[i - 1][mask] + cost[i - 1][j]);
                }
            }
        }

        // Step 4: Final step to ensure all group2 points are connected
        int res = Integer.MAX_VALUE;
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = dp[m][mask];
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) == 0) {
                    sum += minRight[j]; // add cost to connect unconnected group2[j]
                }
            }
            res = Math.min(res, sum);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] cost = {
            {15, 96},
            {36, 2}
        };

        System.out.println("Minimum Total Cost: " + connectTwoGroups(cost));
    }
}
