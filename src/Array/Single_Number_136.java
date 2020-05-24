package Array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Single_Number_136 {
//    public int singleNumber(int[] nums) {
//        Set<Integer> numSet = new HashSet<>();
//        int sumArray = 0;
//        for (int num : nums) {
//            numSet.add(num);
//            sumArray += num;
//        }
//        Iterator<Integer> itor = numSet.iterator();
//        int sumSet = 0;
//        while (itor.hasNext()) {
//            sumSet += itor.next();
//        }
//        return 2 * sumSet - sumArray;
//    }
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int n : nums) {
            single = single ^ n;
        }
        return single;
    }

    public static void main(String[] args) {
        Single_Number_136 s = new Single_Number_136();
        int[] x = {9,9,1,1,-7,8,8};
        int Excepted = -7;
        int Actual = s.singleNumber(x);
        System.out.println("Excepted: " + Excepted + ". Actual: " + Actual);
    }
}
