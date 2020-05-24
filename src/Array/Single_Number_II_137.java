package Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/** Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Input: [2,2,3,2]
 * Output: 3
 * */


public class Single_Number_II_137 {

    /** Bits operation (the best solution) */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : nums) {
                sum += (num >> i) & 1; /** (num >> i) & 1: 取出第i位的值（将num按位右移i位，再与0001取同，得到最右侧位的值）*/
            }
            sum = sum % 3; /** 在第i位的求和，对重复次数取余，得到single在该位的值 */
            if (sum != 0) ans |= sum << i;
        }
        return ans;
    }

//    /** HashMap (second-best solution) */
//    public int singleNumber(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.get(num) == null) map.put(num, 1);
//            else if (map.get(num) == 1) map.replace(num, 2);
//            else map.remove(num);
//        }
//        System.out.println(map.size());
//        return map.keySet().iterator().next();
//    }

//    /** HashSet */
//    public int singleNumber(int[] nums) {
//        HashSet<Integer> all = new HashSet<>();
//        HashSet<Integer> dup = new HashSet<>();
//        for (int num : nums) {
//            if (!all.add(num)) {
//                dup.add(num);
//            }
//        }
//        all.removeAll(dup);
//        return all.iterator().next();
//    }

    public static void main(String[] args) {
        Single_Number_II_137 s = new Single_Number_II_137();
        int[] x = {9,9,9,1,1,1,-7,8,8,8};
        int Excepted = -7;
        int Actual = s.singleNumber(x);
        System.out.println("Excepted: " + Excepted + ". Actual: " + Actual);
    }
}
