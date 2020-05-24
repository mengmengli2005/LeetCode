package Tree;

public class Populating_Next_Right_Pointers_in_Each_Node_II_117 {
    public Node connect(Node root) {
        Node ans = root;
        while(root != null){
            Node tempChild = new Node(0);
            Node currentChild = tempChild;
            while(root!=null){
                if (root.left != null) {
                    currentChild.next = root.left;
                    currentChild = currentChild.next;
                }
                if (root.right != null) {
                    currentChild.next = root.right;
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = tempChild.next;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
