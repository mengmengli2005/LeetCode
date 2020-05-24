package Array;

public class Remove_Duplicates_from_Sorted_Array_II_80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int len = 1, size = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] != nums[i - 1]) {
                len = 1;
                nums[size++] = nums[i++];
            } else if (len < 2) {
                len++;
                nums[size++] = nums[i++];
            } else i++;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] x = {0,0,1,1,1,1,2,3,3};
        Remove_Duplicates_from_Sorted_Array_II_80 s = new Remove_Duplicates_from_Sorted_Array_II_80();
        int ans = s.removeDuplicates(x);
        System.out.println(ans);
    }

}
