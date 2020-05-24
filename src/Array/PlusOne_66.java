package Array;
/**Examples:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Input: [9]
 * Output: [1,0]
 *  */

public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i --) {
            if (digits[i] != 9) {
                digits[i] += 1;
                break;
            } else digits[i] = 0;
        }
        if (digits[0] == 0) {
            int[] plus = new int[len + 1];
            plus[0] = 1;
            return plus;
        } else return digits;
    }

    public static void main(String[] args) {
        PlusOne_66 s = new PlusOne_66();
        int[] x = {9,9};
        int[] Excepted = {1, 0, 0};
        int[] Actual = s.plusOne(x);
        System.out.println("Excepted: " + Excepted + ". Actual: " + Actual);
    }
}
