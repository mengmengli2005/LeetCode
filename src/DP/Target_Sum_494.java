package DP;

import java.util.Arrays;

public class Target_Sum_494 {
    // recursion + memo
    public static final int top = 5;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) return 0;
        int[][] memo = new int[nums.length][2 * top + 1];
        for (int[] row : memo) Arrays.fill(row, Integer.MAX_VALUE);
        return dfs(nums, 0, S, 0, memo);
    }
    private int dfs(int[] nums, int pos, int S, int sum, int[][] memo) {
        if (pos == nums.length) {
            if (S == sum) return 1;
            else return 0;
        }
        if (memo[pos][S + top] != Integer.MAX_VALUE) return memo[pos][S + top];
        memo[pos][S + top] = dfs(nums, pos + 1, S, sum - nums[pos], memo)
                + dfs(nums, pos + 1, S, sum + nums[pos], memo);
        return memo[pos][S + top];
    }

    public static void main(String[] args) {
        int[] x = {1,1,1,1,1};
        int S = 3;
        Target_Sum_494 s = new Target_Sum_494();
        int ans = s.findTargetSumWays(x, S);
        System.out.println(ans);
    }
}
