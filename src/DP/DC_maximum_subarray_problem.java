package DP;

public class DC_maximum_subarray_problem {
    class ans {
        int leftLow;
        int rightHigh;
        int maxSum;
        ans(int l, int r, int s) {
            leftLow = l;
            rightHigh = r;
            maxSum = s;
        }
    }

    public ans findMain(int[] A) {
        return findMaximumSubarray(A, 0, A.length - 1);
    }

    private ans findMaximumSubarray(int[] A, int l, int r) {
        if (l == r) return new ans(l, r, A[l]);
        int m = l + (r - l) / 2;
        ans left = findMaximumSubarray(A, l, m);
        ans right = findMaximumSubarray(A, m + 1, r);
        ans cross = findMaxCrossSubarray(A, l, m, r);

        if (left.maxSum > right.maxSum && left.maxSum > cross.maxSum) return left;
        if (right.maxSum > left.maxSum && right.maxSum > cross.maxSum) return right;
        else return cross;
    }

    private ans findMaxCrossSubarray(int[] A, int l, int m, int r) {
        if (l == r) return new ans(l, r, A[l]);

        int leftSum = Integer.MIN_VALUE, leftLow = m, sum = 0;
        for (int left = m; left >= l; left--) {
            sum += A[left];
            if (sum > leftSum) {
                leftLow = left;
                leftSum = sum;
            }
        }

        sum = 0;
        int rightSum = Integer.MIN_VALUE, rightHigh = m + 1;
        for (int right = m + 1; right <= r; right++) {
            sum += A[right];
            if (sum > rightSum) {
                rightHigh = right;
                rightSum = sum;
            }
        }

        return new ans(leftLow, rightHigh, leftSum + rightSum);
    }

    public static void main(String[] args){
        int[] x = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        DC_maximum_subarray_problem s = new DC_maximum_subarray_problem();
        ans res = s.findMain(x);
    }
}
