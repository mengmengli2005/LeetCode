package LinkedList;
import java.util.Arrays;

public class Merge_k_Sorted_Lists_23 {


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-5);
        dummy.next = lists[0];

        for (int i = 1; i < lists.length; i++) {
            ListNode temp = lists[i], pre = dummy, cur = dummy.next;
            while (temp != null) {
                while (cur != null && temp.val > cur.val) {
                    pre = cur;
                    cur = cur.next;
                }
                pre.next = new ListNode(temp.val); //插入
                pre.next.next = cur;
                temp = temp.next; //指针右移

                pre = dummy;
                cur = dummy.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode x1 = new ListNode(1);
        x1.next = new ListNode(4);
        x1.next.next = new ListNode(5);
        ListNode x2 = new ListNode(1);
        x2.next = new ListNode(3);
        x2.next.next = new ListNode(4);
        ListNode[] x = {x1, x2};

        Merge_k_Sorted_Lists_23 s = new Merge_k_Sorted_Lists_23();
        ListNode output = s.mergeKLists(x);
        System.out.println(output);
    }
}
