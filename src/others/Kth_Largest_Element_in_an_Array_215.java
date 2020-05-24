package others;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array_215 {
//    // partition() in QuickSort
//    public int findKthLargest(int[] nums, int k) {
//        if (nums.length == 0 || k < 1 || k > nums.length) return -1;
//        k = nums.length - k;
//        int lo = 0, hi = nums.length - 1;
//
//        while (lo < hi) {
//            int j = partition(nums, lo, hi);
//            if (j == k) return nums[j];
//            else if (j < k) lo = j + 1;
//            else hi = j - 1;
//        }
//        return nums[k];
//    }
//    public int partition(int[] a, int lo, int hi) {
//        if (lo >= hi) return lo;
//        int i = lo, j = hi + 1, v = a[lo];
//        while (true) {
//            while (a[++i] < v) if (i == hi) break;
//            while (v < a[--j]) if (j == lo) break;
//            if (i >= j) break;
//            exch(a, i, j);
//        }
//        exch(a, j, lo);
//        return j;
//    }
//    public static void exch(int[] a, int i, int j) {
//        int tmp = a[i];
//        a[i] = a[j];
//        a[j] = tmp;
//    }

    // MinHeap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int n : nums) minHeap.add(n);
        while (minHeap.size() > k) minHeap.poll();
        int ans = minHeap.poll();
        return ans;
    }

    public static void main(String[] args) {
        int[] x = new int[]{-1,0,1,2,5,6};
        int k = 2;
        Kth_Largest_Element_in_an_Array_215 s = new Kth_Largest_Element_in_an_Array_215();
        int ans = s.findKthLargest(x, k);
    }
}
