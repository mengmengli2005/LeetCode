package BackTracking;

import java.util.List;
import java.util.ArrayList;

public class Letter_Combinations_of_a_Phone_Number_17 {
    String digits;
    List<String> ans;
    String[] map = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        this.ans = new ArrayList<>();

        backTrack(new StringBuilder(), 0);
        return ans;
    }
    private void backTrack(StringBuilder sb, int nextDigit) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        int pos = digits.charAt(nextDigit) - '0';
        String cur = this.map[pos];
        for (int i = 0; i < cur.length(); i++) {
            sb.append(cur.charAt(i));
            backTrack(sb, nextDigit + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Letter_Combinations_of_a_Phone_Number_17 s = new Letter_Combinations_of_a_Phone_Number_17();
        String x = "23";
        List<String> y = s.letterCombinations(x);
        System.out.println(y);
    }
}
