package DP;

public class Perfect_Squares_279 {
    public int numSquares(int n) {
        int ans = Integer.MAX_VALUE;
        ans = dfs(n, 0, ans);
        return ans;
    }

    private int dfs(int n, int count, int ans) {
        if (n == 0) return Math.min(ans, count);

        int maxFactor = (int) Math.sqrt(n);
        for (int i = maxFactor; i > 0; i--) {
            int factor = i * i;
            for (int j = n / factor; j > 0 && count + j < ans; j--) {
                ans = Math.min(ans, dfs(n - factor * j, count + j, ans));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Perfect_Squares_279 s = new Perfect_Squares_279();
        int ans = s.numSquares(12);
        System.out.println(ans);
    }
}
