package Array;

public class Sort_Colors_75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int j = 0, k = n-1;
        for (int i=0; i <= k; i++) {
            if (nums[i] == 0)
                swap(nums, i, j++);
            else if (nums[i] == 2)
                swap(nums, i--, k--);
        }
    }
    private void swap(int[] A, int i, int j) {
        int n = A.length;
        if (i < 0 || i >= n || j < 0 || j >= n) return;
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int[] x = {2,0,2,1,1,0};
        Sort_Colors_75 s = new Sort_Colors_75();
        s.sortColors(x);
        System.out.println(x);
    }
}
