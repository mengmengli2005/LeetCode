package offer;

public class String_Pattern_Matching {
    public static boolean match(char[] str, char[] pattern) {
        return helper(str, 0, pattern, 0);
    }

    private static boolean helper(char[] str, int i, char[] pattern, int j) {
        if (i == str.length && j == pattern.length) return true;
        else if (j >= pattern.length) return false;

        if (j + 1 < pattern.length && pattern[j + 1] == '*') { //a2后面不是*
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                return helper(str, i, pattern, j + 2) || helper(str, i + 1, pattern, j);
            } else {
                return helper(str, i, pattern, j + 2);
            }
        } else {
            if (i < str.length && (str[i] == pattern[j] || pattern[j] == '.')) {
                return helper(str, i + 1, pattern, j + 1);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String str = "a";
        String pattern = ".";
        boolean ans = match(str.toCharArray(), pattern.toCharArray());
    }
}