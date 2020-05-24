package Array;
import java.util.HashMap;
/**这题做错的过程中，没有考虑以下几点：
 * 1. 没有把所有<key, value> pairs放进HashMap里，就开始匹配了，导致大概率匹配不到；
 * 2. 没有考虑会有相同的key，导致判断map.containsKey()时，匹配成了第一个数；比如 target = 10，nums = [2,5,5,11]时，map.get(target - nums[i])得到的是i自己；
 * 3. 其他Array构造和表示上的小错误，比如int[] ans = [i, j]不对，应该用花括号{}；
 * */
public class Two_Sum_1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // num as key, index as value
        for (int i = 0; i < nums.length; i++) { /** 这里对应【错误】1*/
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int j = map.get(target - nums[i]);
                if (i != j) {
                    int[] ans = {i, j};
                    return ans;
                }
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        Two_Sum_1 s = new Two_Sum_1();
        int[] x = {2,5,5,11};
        int t = 10;
        int[] Excepted = {1, 2};
        int[] Actual = s.twoSum(x, t);
        System.out.println("Excepted: " + Excepted + ". Actual: " + Actual);
    }

}
