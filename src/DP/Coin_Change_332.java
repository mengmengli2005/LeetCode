package DP;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Coin_Change_332 {
    //DFS + 剪枝
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coins = myReverse(coins);
        int ans = Integer.MAX_VALUE;
        ans = coinChange(coins, 0, amount, 0, ans);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int coinChange(int[] coins, int pos, int amount, int count, int ans) {
        int coin = coins[pos];
        if (pos == coins.length - 1) {
            if (amount % coin == 0) ans = Math.min(ans, count + amount / coin);
        } else {
            for (int i = amount / coin; i >= 0 && count + i < ans; i--) {
                ans = coinChange(coins, pos + 1, amount - coin * i, count + i, ans);
            }
        }
        return ans;
    }

    private int[] myReverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length -1 - i];
            nums[nums.length -1 - i] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Coin_Change_332 s = new Coin_Change_332();
        int ans = s.coinChange(coins, amount);
        System.out.println(ans);
    }
}
