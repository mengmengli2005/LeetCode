package Tree;

import java.util.List;
import java.util.ArrayList;

public class Symmetric_Tree_101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        List<Integer> list = inOrderRecursion(root);
        int N = list.size();
        for (int i = 0; i < N / 2; i++) {
            if (list.get(i) != list.get(N - i)) return false;
        }
        return true;
    }

    public List<Integer> inOrderRecursion(TreeNode root) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();

        inOrderRecursion(root.left);
        list.add(root.val);
        inOrderRecursion(root.right);
        return list;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode root = new TreeNode(1);
        root.left = left;
        root.right = null;

        Symmetric_Tree_101 s = new Symmetric_Tree_101();
        boolean ans = s.isSymmetric(root);
    }

}
