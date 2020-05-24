package Array;

public class Find_Minimum_in_Rotated_Sorted_Array_II_153 {

//    /** Recursive. */
//    public int findMin(int[] nums) {
//        return findHelper(nums, 0, nums.length - 1);
//    }
//    private int findHelper(int[] n, int l, int r) {
//        if (l + 1 >= r) return min(n[l], n[r]);
//        if (n[l] < n[r]) return n[l];
//        int mid = l + (r - l) / 2;
//        return min(findHelper(n, l, mid), findHelper(n, mid, r));
//    }
//    private int min(int a, int b) {
//        if (a < b) return a;
//        return b;
//    }

    /** Iterative. */
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, m = 0;
        while (l + 1 < r) {
            m = l + (r - l) / 2;
            if (nums[m] > nums[r]) l = m;
            else if (nums[m] < nums[r]) r = m;
            else r--;
        }
        if (nums[l] < nums[r]) return nums[l];
        return nums[r];
    }

    public static void main(String[] args) {
        Find_Minimum_in_Rotated_Sorted_Array_II_153 s = new Find_Minimum_in_Rotated_Sorted_Array_II_153();
//        int[] x = {3,3,4,0,1,2,3};
        int[] x = {1,3,5};
        int Excepted = 0;
        int Actual = s.findMin(x);
        System.out.println("Excepted: " + Excepted + ". Actual: " + Actual);
    }
}
