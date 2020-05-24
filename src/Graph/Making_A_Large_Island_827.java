package Graph;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Making_A_Large_Island_827 {
    int[][] grid;
    int N;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};

    public int largestIsland(int[][] grid) {
        N = grid.length;
        this.grid = grid;

        int groupId = 2;
        int[] area = new int[N * N + 2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j ++) {
                if (grid[i][j] == 1)
                    area[groupId] = DFS(i, j, groupId++);
            }
        }

        int maxArea = 0, curArea = 0;
//        for (int x : area) maxArea = Math.max(maxArea, x);
        Set<Integer> setOfGroupId = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    for (int n : neighbors(i, j)) {
                        groupId = this.grid[n/N][n%N];
                        if (groupId >1 && !setOfGroupId.contains(groupId)) {
                            curArea += area[groupId];
                            setOfGroupId.add(groupId);
                        }
                    }
                    maxArea = Math.max(maxArea, curArea);
                }
            }
        }

        return maxArea;
    }

    private int DFS(int i, int j, int groupId) {
        int ans = 1;
        grid[i][j] = groupId;

        for (int n : neighbors(i, j)) {
            if (this.grid[n / N][n % N] == 1) {
                this.grid[n / N][n % N] = groupId;
                ans += DFS(n / N, n % N, groupId);
            }
        }
        return ans;
    }

    private List<Integer> neighbors(int i, int j) {
        List<Integer> neighbors = new ArrayList<>();
        if (i < 0 || i >= N || j < 0 || j >= N) return neighbors;

        int newR = 0, newC = 0;
        for (int d = 0; d < 4; d++) {
            newR = i + dr[d];
            newC = j + dc[d];
            neighbors.add(newR * N + newC);
        }
        return neighbors;
    }

    public static void main(String[] args) {
        int[][] x = {{1,0},{0,1}};
        Making_A_Large_Island_827 s = new Making_A_Large_Island_827();
        int ans = s.largestIsland(x);
        System.out.println(ans);
    }

    List<Integer>[] Graph = (List<Integer>[]) new Object[N];
}
