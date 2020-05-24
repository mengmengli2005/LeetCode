package Array;
import java.util.Arrays;

public class H_Index_274 {
    public int hIndex(int[] citations) {
        int N = citations.length;
        if (N == 0) return 0;

        Arrays.sort(citations);
        int i = 0;
        while (i < N && citations[i] < N - i) i++;
        return N - i;
    }

    public static void main(String[] args) {
        int[] x = {0};
        H_Index_274 s = new H_Index_274();
        int ans = s.hIndex(x);
        System.out.println(ans);
    }
}
