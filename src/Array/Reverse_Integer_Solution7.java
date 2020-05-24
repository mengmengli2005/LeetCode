package Array;
/** Given a 32-bit signed integer, reverse digits of an integer.
 * Inputs:  123, -123, 120
 * Outputs: 321, -321, 21
 * */

public class Reverse_Integer_Solution7 {
     // 方法二
     public int reverse(int x) {
         int rev = 0;
         while (x != 0) {
             int pop = x % 10;
             if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
             if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
             rev = rev * 10 + pop;
             x = x / 10;
         }
         return rev;
     }

//    // 方法一
//    public int reverse(int x) {
//        boolean flag = false;
//        if (x < 0) {
//            flag = true;
//            x = 0 - x;
//        }
//        int p = x;
//        int rev = 0;
//        while (p > 0) {
//            int mod = p % 10;
//            int result = rev * 10 + mod;
//            if ((result - mod) / 10 != rev) return 0;
//            rev = result;
//            p = p / 10;
//        }
//
//        if (flag) rev = 0 - rev;
//
//        return rev;
//    }

    public static void main(String[] args) {
        int x = 1534236469;
        Reverse_Integer_Solution7 s = new Reverse_Integer_Solution7();
        int xR = s.reverse(x);
        System.out.println("Excepted: " + x + ". Actual: " + xR);
    }
//     public int reverse(int x) {
//         if (x == 0) return 0;
//         String str = String.valueOf(Math.abs(x));
//         String strReverse = new StringBuilder(str).reverse().toString();
//         char[] c = strReverse.toCharArray();
//         removeZero(c);
//         int result = Integer.parseInt(new String(c));
//         if (x < 0) result = -result;
//         return result;
//     }

//     public void removeZero(char[] c) {
//         if (!isZero(Character.toString(c[0]))) return;
//         else {
//             c.remove(0);
//             removeZero(c);
//         }
//     }

//     public boolean isZero(String s) {
//         if (s == "0") return true;
//         return false;
//     }
}
