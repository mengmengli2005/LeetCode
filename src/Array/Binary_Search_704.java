package Array;
/**Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums.
 * If target exists, then return its index, otherwise return -1.
 *
 * 需要考虑到很多corner cases:
 * 1. Array长度为1，如x = [4], t = 9：开始时判断target是否在Array区间内；
 * 2. Array长度为2，如x = [0,8], t = 4：在while loop内判断 max 和 min 相邻时，是否在端点找到target；
 * 3. 一定要检查 while loop 能否结束，否则将无限循环。
 * */
public class Binary_Search_704 {
    public int search(int[] nums, int target) {
        int index = -1, min = 0, max = nums.length - 1;
        while (max >= min) {
            int mid = (max + min) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            }
            if (nums[mid] < target) min = mid + 1;
            else max = mid - 1;
        }
        return index;
    }

//    public int search(int[] nums, int target) {
//        int index = -1, min = 0, max = nums.length - 1;
//        if (target > nums[max] || target < nums[min]) return index;
//        while (max - min >= 0) {
//            if (nums[max] == target) return max;
//            if (nums[min] == target) return min;
//            if ((max - min) == 1 && nums[max] != target && nums[min] != target) return index;
//            int half = (max + min) / 2;
//            if (nums[half] == target) return half;
//            if (nums[half] < target) min = half;
//            else max = half;
//        }
//        return index;
//    }

    public static void main(String[] args) {
        Binary_Search_704 s = new Binary_Search_704();
        int[] x = {-1,0,3,5,9,12};
//        int[] x= {0,9};
        int t = 9;
        int Excepted = 4;
        int Actual = s.search(x, t);
        System.out.println("Excepted: " + Excepted + ". Actual: " + Actual);
    }
}
