import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n = in.nextInt();
            int m = in.nextInt();
            int a = in.nextInt();
            int b = in.nextInt();
            int ans = 0;

            if (m <= b) {
                ans = n >= a ? m : 0;
            } else if (a <= 0) {
                ans = m;
            } else {
                int rem = m, cur_a = a;
                for (int t = 0; t < n; t++) {
                    if (rem <= 0) break;
                    cur_a -= 1;
                    if (cur_a <= 0) {
                        rem -= b;
                        cur_a = a;
                    }
                }
                ans = rem <= 0 ? m : n - rem;
            }

            System.out.println(ans);
        }
    }
}