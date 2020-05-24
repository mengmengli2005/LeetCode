package Array;

public class Find_Peak_Element_162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length, left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; /** Avoid OVERFLOW problem. */
            if (nums[mid] < nums[mid + 1]) left = mid + 1; /** nums[mid + 1] always exist, because mid = XXX / 2 (取整操作将抹去小数，即向下取整) */
            else right = mid;
        }
        return left;
    }

    public static void main(String[] args) {
        Find_Peak_Element_162 s = new Find_Peak_Element_162();
        int[] x = {-1,6,3,2,9,12};
        int Excepted = 1;
        int Actual = s.findPeakElement(x);
        System.out.println("Excepted: " + Excepted + ". Actual: " + Actual);
    }
}
