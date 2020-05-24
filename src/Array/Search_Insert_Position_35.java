package Array;

public class Search_Insert_Position_35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length, max = len - 1, min = 0;
        while (max >= min) {
            int mid = (max + min) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) min = mid + 1;
            else max = mid - 1;
        }
        return min;
    }

    public static void main(String[] args) {
        Search_Insert_Position_35 s = new Search_Insert_Position_35();
        int[] x = {-1,0,3,5,9,12};
        int t = 8;
        int Excepted = 4;
        int Actual = s.searchInsert(x, t);
        System.out.println("Excepted: " + Excepted + ". Actual: " + Actual);
    }
}
