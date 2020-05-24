package LinkedList;

public class Reverse_Linked_List_206 {

//     // 我的iterative，非in space
//     ListNode reverseList(ListNode head) {
//         ListNode dummy = new ListNode(-5), post = dummy.next, cur = head;
//         while (cur != null) {
//             dummy.next = new ListNode(cur.val);
//             dummy.next.next = post;
//             post = dummy.next;
//             cur = cur.next;
//         }
//         return dummy.next;
//     }

//    // recursive
//    ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode r = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;
//        return r;
//    }

    /* iterative solution, in space */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode x1 = new ListNode(1);
        x1.next = new ListNode(2);
        x1.next.next = new ListNode(3);
        x1.next.next.next = new ListNode(4);
        x1.next.next.next.next = new ListNode(5);

        Reverse_Linked_List_206 s = new Reverse_Linked_List_206();
        ListNode output = s.reverseList(x1);
    }
}
