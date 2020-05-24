package Array;

public class Find_Minimum_in_Rotated_Sorted_Array_153 {
    private int findMin(int[] nums) {
        return findHelper(nums, 0, nums.length - 1);
    }
    private int findHelper(int[] n, int l, int r) {
        if (l + 1 >= r) return min(n[l], n[r]);
        if (n[l] < n[r]) return n[l];
        int mid = l + (r - l) / 2;
        return min(findHelper(n, l, mid), findHelper(n, mid, r));
    }

    private int min(int x, int y) {
        if (x > y) return y;
        return x;
    }

    public static void main(String[] args) {
        Find_Minimum_in_Rotated_Sorted_Array_153 s = new Find_Minimum_in_Rotated_Sorted_Array_153();
        int[] x = {3,4,5,1,2};
        int Excepted = 1;
        int Actual = s.findMin(x);
        System.out.println("Excepted: " + Excepted + ". Actual: " + Actual);
    }
}
