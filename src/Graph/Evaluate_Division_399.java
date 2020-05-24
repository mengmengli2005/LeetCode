package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.HashMap;

public class Evaluate_Division_399 {
    static final double NONE = -1.0;
    static final double BASE = 1.0;

    class Edge {
        String from;
        String to;
        double weight;
        Edge(String f, String t, double w) {
            this.from = f;
            this.to = t;
            this.weight = w;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        if (equations.size() == 0 || equations == null || queries.size() == 0 || queries == null) return new double[0];
        HashMap<String, ArrayList<Edge>> map = buildGraph(equations, values);

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            if (!map.containsKey(start) || !map.containsKey(end)) ans[i] = NONE;
            else if (start == end) ans[i] = BASE;
            else ans[i] = dfs(map, start, end, new HashSet<>(), BASE);
        }
        return ans;
    }

    private double dfs(HashMap<String, ArrayList<Edge>> map, String start, String end, HashSet<String> visit, double product) {
        if (!map.containsKey(start) || !map.containsKey(end)) return NONE;
        if (start == end) return product;

        visit.add(start);
        double newProduct = NONE;
        ArrayList<Edge> next = map.get(start);
        for (Edge e : next) {
            if (visit.contains(e.to)) continue;
            newProduct = dfs(map, e.to, end, visit, product * e.weight);
            if (newProduct != NONE) break;
        }
        visit.remove(start);
        return newProduct;
    }

    private HashMap<String, ArrayList<Edge>> buildGraph(List<List<String>> equ, double[] values) {
        HashMap<String, ArrayList<Edge>> map = new HashMap<>();
        for (int i = 0; i < equ.size(); i++) {
            String pre = equ.get(i).get(0);
            String post = equ.get(i).get(1);
            if (!map.containsKey(pre)) {
                ArrayList<Edge> newPre = new ArrayList<>();
                map.put(pre, newPre);
            }
            if (!map.containsKey(post)) {
                ArrayList<Edge> newPost = new ArrayList<>();
                map.put(post, newPost);
            }
            map.get(pre).add(new Edge(pre, post, values[i]));
            map.get(post).add(new Edge(post, pre, 1 / values[i]));
        }
        return map;
    }

    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<String> e1 = new ArrayList<>();List<String> e2 = new ArrayList<>();
        e1.add("a");e1.add("b");e2.add("b");e2.add("c");
        equations.add(e1);equations.add(e2);
        double[] values = {2.0, 3.0};
        List<List<String>> queries = new ArrayList<>();
        List<String> q1 = new ArrayList<>(), q2 = new ArrayList<>(), q3 = new ArrayList<>(),q4 = new ArrayList<>(),q5 = new ArrayList<>();
        q1.add("a");q1.add("c");queries.add(q1);
        q2.add("b");q2.add("a");queries.add(q2);
        q3.add("a");q3.add("e");queries.add(q3);
        q4.add("a");q4.add("a");queries.add(q4);
        q5.add("x");q5.add("x");queries.add(q5);

        Evaluate_Division_399 s = new Evaluate_Division_399();
        double[] ans = s.calcEquation(equations, values, queries);
    }
}
