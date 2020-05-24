package BackTracking;

import java.util.List;
import java.util.ArrayList;

public class Letter_Case_Permutation_784 {
    String S;
    List<String> ans;

    public List<String> letterCasePermutation(String S) {
        this.ans = new ArrayList<>();
        this.S = S;
        boolean[] visit = new boolean[S.length()];
        backTrack(new StringBuilder(), visit);
        return ans;
    }

    private void backTrack(StringBuilder sb, boolean[] visit) {
        if (sb.length() == S.length()) {
            ans.add(sb.toString());
        } else {
            for (int c = 0; c < S.length(); c++) {
                if (visit[c]) continue;
                if (isNum(S.charAt(c))) {
                    sb.append(S.charAt(c));
                    visit[c] = true;
                    if (sb.length() == S.length()) ans.add(sb.toString());
                }
                else {
                    visit[c] = true;
                    sb.append(S.charAt(c));
                    backTrack(sb, visit);
                    sb.deleteCharAt(sb.length() - 1);
                    sb.append(changeLetter(S.charAt(c)));
                    backTrack(sb, visit);
                    sb.deleteCharAt(sb.length() - 1);
                    visit[c] = false;
                }
            }
        }
    }

    private char changeLetter(char chr) {
        if (chr >= 'A' && chr <= 'Z') return Character.toLowerCase(chr);
        if (chr >= 'a' && chr <= 'z') return Character.toUpperCase(chr);
        return chr;
    }
    private boolean isNum(char chr) {
        return chr >= '0' && chr <= '9';
    }

    public static void main(String[] args) {
        Letter_Case_Permutation_784 s = new Letter_Case_Permutation_784();
        String x = "a1b2";
        List<String> y = s.letterCasePermutation(x);
        System.out.println(y);
    }
}
