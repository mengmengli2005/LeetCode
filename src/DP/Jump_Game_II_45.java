package DP;

public class Jump_Game_II_45 {
    // Greedy
    public int jump(int[] nums) {
        int jump = 0, curMax = 0, nextMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);
            if (i == curMax) {
                jump++;
                curMax = nextMax;
            }
        }
        return jump;
    }

//    //DP
//    public int jump(int[] nums) {
//        if (nums.length <= 1 || nums == null) return 0;
//
//        int[] dp = new int[nums.length];
//        dp[0] = 0;
//        dp[1] = 1;
//
//        for (int i = 2; i < nums.length; i++) {
//            int firstIndex = Math.max(i - nums[nums.length - 1 - i], 0);
//            int min = Integer.MAX_VALUE;
//            for (int j = firstIndex; j < i; j++) {
//                min = Math.min(min, dp[j]);
//            }
//            dp[i] = min + 1;
//        }
//        return dp[nums.length - 1];
//    }

    public static void main(String[] args) {
        int[] x = {2,3,1,1,4};
        Jump_Game_II_45 s = new Jump_Game_II_45();
        int ans = s.jump(x);
        System.out.println(ans);
    }
}
