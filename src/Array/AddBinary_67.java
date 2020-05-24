package Array;
/**Examples:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * */
public class AddBinary_67 {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0; //进位符号
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) sum = sum + a.charAt(i--) - '0';
            if (j >= 0) sum = sum + b.charAt(j--) - '0';
            carry = sum / 2;
            sb.append(sum % 2);
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary_67 s = new AddBinary_67();
        String a = "1010";
        String b = "11";
        String Excepted = "1101";
        String Actual = s.addBinary(a, b);
        System.out.println("Excepted: " + Excepted + ". Actual: " + Actual);
    }

    /** Notes:
     * 1. 我写的bug (a.charAt() - '0' 开始没有 -'0') ，char 在计算机中表示为一个整型数字，'1'！=1，而是65；所以将char'1'转换为num，需要先减去'0'；
     * 2. StringBuilder has many useful functions, like .append()  .delete()  .insert()   .charAt(), etc.
     * 3. Use "carry" to remember the carry bit.
     * 4. 在 N-进制 中，carry = sum / N 标示进位； sum % N 标示某位的值；
     * */
}
