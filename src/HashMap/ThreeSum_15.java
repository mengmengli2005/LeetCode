package HashMap;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    Integer[] cand = new Integer[]{nums[i], nums[l], nums[r]};
                    List<Integer> tmp = Arrays.asList(cand);
                    ans.add(tmp);
                    while (l + 1 < r && nums[l] == nums[l + 1]) l++;
                    while (r - 1 > l && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) l++;
                else r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x = new int[]{-1,0,1,2,-1,-4};
        ThreeSum_15 s = new ThreeSum_15();
        List<List<Integer>> ans = s.threeSum(x);
    }
}
