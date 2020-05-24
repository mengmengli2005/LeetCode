package DP;
import java.util.ArrayList;
import java.util.List;

public class Word_Break_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        ArrayList<String> head = new ArrayList<>();
        for (String d : wordDict) {
            int len = d.length();
            String part = s.substring(0, len);
            if (part.equals(d)) head.add(d);
        }
        for (String d : head) {
            if (findWord(s, d.length(), wordDict)) return true;
        }
        return false;
    }

    private boolean findWord(String s, int pos, List<String> wordDict) {
        if (pos == s.length()) return true;
        for (String d : wordDict) {
            int len = d.length();
            if (pos + len > s.length()) continue;
            if (s.substring(pos, pos + len).equals(d))
                return findWord(s, pos + len, wordDict);
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");
        Word_Break_139 solution = new Word_Break_139();
        boolean ans = solution.wordBreak(s, wordDict);
    }
}
