package BackTracking;
import java.util.List;
import java.util.ArrayList;

public class palindrome_Partitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if (s == null || s.length() == 0) return ans;
        dfs(s, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(String s, int pos, ArrayList<String> tmpList, List<List<String>> ans) {
        if (pos == s.length()) {
            ans.add(new ArrayList<String>(tmpList));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPalind(s, pos, i)) {
                tmpList.add(s.substring(pos, i + 1));
                dfs(s, i + 1, tmpList, ans);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
    private boolean isPalind(String s, int left, int right) {
        if (left == right) return true;
        if (left > right) return false;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        palindrome_Partitioning_131 s = new palindrome_Partitioning_131();
        String input = "abb";
        List<List<String>> ans = s.partition(input);
        System.out.println(ans);
    }
}
