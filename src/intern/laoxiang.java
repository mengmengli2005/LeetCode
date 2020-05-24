package intern;
import java.io.*;
import java.util.*;

public class laoxiang {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int N = cin.nextInt();
            int M = cin.nextInt();

            Map<Integer, ArrayList<Integer>> relation = new HashMap<>();
            for (int i = 0; i < N; i++) {
                relation.put(i, new ArrayList<Integer>());
            }
            for (int m = 0; m < M; m++) {
                int a = cin.nextInt();
                int b = cin.nextInt();
                int r = cin.nextInt();
                if (r == 1) {
                    relation.get(a).add(b);
                    relation.get(b).add(a);
                }
            }

            int count = 0;
            int[] people = new int[N + 1];
            dfs(1, relation, people);
            for (int p = 1; p < people.length; p++) {
                if (people[p] == 1) count++;
            }

            System.out.println(count);
        }
    }

    private static void dfs(int i, Map<Integer, ArrayList<Integer>> relation, int[] v) {
        if (relation.get(i).size() == 0) {
            return;
        }
        for (int next : relation.get(i)) {
            if (v[next] == 0) {
                v[next] = 1;
                dfs(next, relation, v);
            }
        }
    }
}