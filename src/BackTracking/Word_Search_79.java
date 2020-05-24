package BackTracking;

import java.util.ArrayList;

public class Word_Search_79 {
    int row, col;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    char[][] board;
    String word;
    boolean ans = false;

    public boolean exist(char[][] board, String word) {
        if (word.isEmpty()) return true;
        this.row = board.length;
        if (row == 0) return false;
        this.col = board[0].length;
        this.board = board;
        this.word = word;
        boolean[] visit = new boolean[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                backTrack(i * row + j, 0, visit);
                if (ans) break;
            }
        }
        return ans;
    }

    private void backTrack(int start, int wordPos, boolean[] visit) {
        if (wordPos == word.length() - 1) {
            ans = true;
            return;
        }
        if (board[start / col][start % col] != word.charAt(wordPos)) {
            return;
        }
        if (neighbor(start).size() == 0 && board[start/col][start%col] == word.charAt(wordPos)) { // Conner case：处理board只有1个元素的情况
            ans = true;
            return;
        }
        for (int n : neighbor(start)) {
            if (visit[n]) continue;
            visit[n] = true;
            backTrack(n, wordPos + 1, visit);
            visit[n] = false;
        }
    }

    private ArrayList<Integer> neighbor(int index) {
        ArrayList<Integer> neighbor = new ArrayList<>();
        for (int d = 0; d < 4; d++) {
            int newR = index / col + dr[d];
            int newC = index % col + dc[d];
            if (newR >= 0 && newR < row && newC >= 0 && newC < col)
                neighbor.add(newR * col + newC);
        }
        return neighbor;
    }

    public static void main(String[] args) {
        Word_Search_79 s = new Word_Search_79();
        char[][] board = {{'a','b','c'},{'a','e','d'},{'a','f','g'}};
        String word = "abcdefg";
        boolean e = s.exist(board, word);
        System.out.println(e);
    }
}
