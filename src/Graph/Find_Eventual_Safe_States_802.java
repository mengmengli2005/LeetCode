package Graph;

import java.util.List;
import java.util.ArrayList;

public class Find_Eventual_Safe_States_802 {
    int N;//number of nodes
    int[] visit;//0-unvisited, 1-visiting, 2-visited, 3-isCycle

    public List<Integer> eventualSafeNodes(int[][] graph) {
        N = graph.length;
        visit = new int[N];
        for (int i = 0; i < N; i++) {
            if (visit[i] == 0) dfs(graph, i);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (visit[i] == 2) ans.add(i);
        }
        return ans;
    }

    private void dfs(int[][] graph, int pos) {
        if (visit[pos] == 2 || visit[pos] == 3) return;
        if (visit[pos] == 1) {
            for (int i = 0; i < N; i++) {
                if (visit[i] == 1) visit[i] = 3;
            }
            return;
        }

        visit[pos] = 1;
        for (int j = 0; j < graph[pos].length; j++) {
            dfs(graph, graph[pos][j]);
        }
        if (visit[pos] == 1) visit[pos] = 2;
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        Find_Eventual_Safe_States_802 s = new Find_Eventual_Safe_States_802();
        List<Integer> ans = s.eventualSafeNodes(graph);
    }
}
