package Tree;

import java.util.HashMap;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        HashMap<Integer, Integer> map = constructMap(inorder);
        return helper(0, preorder, 0, inorder.length - 1, inorder, map);
    }

    public TreeNode helper(int preStart, int[] preorder, int inStart, int inEnd, int[] inorder,
                           HashMap<Integer, Integer> map) {
        if (preStart > preorder.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIndex = map.get(preorder[preStart]);
        root.left = helper(preStart + 1, preorder, inStart, rootIndex - 1, inorder, map);
        // root.right = helper(preStart + rootIndex + 1 - inStart, preorder, rootIndex + 1, inEnd, inorder, map);
        root.right = helper(rootIndex + 1, preorder, rootIndex + 1, inEnd, inorder, map);
        return root;
    }

    public HashMap<Integer, Integer> constructMap(int[] inorderArray) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorderArray.length; i++) {
            map.put(inorderArray[i], i);
        }
        return map;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,3};
        int[] in = {2,1,3};

        Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105 s = new Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_105();
        TreeNode ans = s.buildTree(pre, in);
    }
}
