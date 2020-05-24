package DP;

public class Delete_and_Earn_740 {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        int n = 10001;
        int[] acc = new int[n];
        for (int i : nums) acc[i]++;

        int i = 0, sum = 0;
        while (i < n - 1) {
            while (acc[i] == 0 && i < n - 1) i++;
            int even = 0, odd = 0;
            while (acc[i] != 0 && i < n - 1) {
                if (i % 2 == 0) even += i * acc[i];
                else odd += i * acc[i];
                i++;
            }
            sum += Math.max(even, odd);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] x = {2, 2, 3, 3, 3, 4};
        Delete_and_Earn_740 s = new Delete_and_Earn_740();
        int ans = s.deleteAndEarn(x);
        System.out.println(ans);
    }
}
