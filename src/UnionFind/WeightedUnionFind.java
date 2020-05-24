package UnionFind;

import java.util.HashMap;

public class WeightedUnionFind {
    private HashMap<Integer, Integer> parent;
    private HashMap<Integer, Integer> size;

    public WeightedUnionFind(int[] nums) {
        parent = new HashMap<>();
        size = new HashMap<>();
        for (int n : nums) {
            parent.put(n, n);
            size.put(n, 1);
        }
    }

    //union find with path compression
    public Integer find(Integer num) {
        if (!parent.containsKey(num)) return null;

        Integer root = num;
        while (!parent.get(root).equals(root)) {
            root = parent.get(root);
        }
        while (num != root) {
            Integer next = parent.get(num);
            parent.put(num, root);
            num = next;
        }
        return root;
    }

    public void union(Integer p, Integer q) {
        Integer pRoot = find(p);
        Integer qRoot = find(q);
        if (pRoot == null || qRoot == null) return;
        if (pRoot == qRoot) return;

        int pSize = size.get(p);
        int qSize = size.get(q);
        if (pSize < qSize) {
            parent.put(pRoot, qRoot);
            size.put(q, pSize + qSize);
        } else {
            parent.put(qRoot, pRoot);
            size.put(p, pSize + qSize);
        }
    }

    public boolean isConnected(Integer p, Integer q) {
        Integer pRoot = find(p);
        Integer qRoot = find(q);
        if (pRoot == null || qRoot == null) return false;
        return pRoot == qRoot;
    }
}
