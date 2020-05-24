package sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] in = new int[]{7,9,3,6,1,0,13};
        mergeSort(in, 0, in.length - 1);
        for (int n : in) System.out.println(n);
    }

    private static void mergeSort(int[] in, int lo, int hi) {
        if (lo >= hi) return;

        int mi = (hi + lo) / 2;
        mergeSort(in, lo, mi); //我的错误：mi - 1
        mergeSort(in, mi + 1, hi);
        merge(in, lo, mi, hi);
    }

    private static void merge(int[] in, int lo, int mi, int hi) {
        if (lo >= hi) return;
        int[] tmp = new int[hi - lo + 1];
        int i = 0;
        int l = lo, r = mi + 1;
        while (l <= mi && r <= hi) {
            if (in[l] < in[r]) tmp[i] = in[l++];
            else tmp[i] = in[r++];
            i++;
        }

        while (l <= mi) tmp[i++] = in[l++];
        while (r <= hi) tmp[i++] = in[r++];

        for (int t = 0; t < tmp.length; t++) {
            in[t + lo] = tmp[t];
        }
    }
}



