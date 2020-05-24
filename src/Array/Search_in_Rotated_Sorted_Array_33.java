package Array;
/** no duplicate
 * find and return the index of the target number.
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4 */
public class Search_in_Rotated_Sorted_Array_33 {

    /** 羊羊的️万能模板 */
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            if (nums[m] > nums[r]) {
                if (target >= nums[l] && target < nums[m]) r = m;
                else l = m;
            } else if (nums[m] < nums[r]) {
                if (target > nums[m] && target <= nums[r]) l = m;
                else r = m;
            }
        }
        if (target == nums[l]) return l;
        else if (target == nums[r]) return r;
        return -1;
    }

    public static void main(String[] args) {
        Search_in_Rotated_Sorted_Array_33 s = new Search_in_Rotated_Sorted_Array_33();
        int[] x = {4,5,6,7,0,1,2};
        int t = 1;
        int Actual = s.search(x, t);
        System.out.println(". Actual: " + Actual);
    }

}
