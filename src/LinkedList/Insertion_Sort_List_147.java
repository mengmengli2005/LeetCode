package LinkedList;

import java.util.List;

public class Insertion_Sort_List_147 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-5), cur = head.next, curPre = head;
        dummy.next = head;
        ListNode checkPre, check, checkNext, curNext;

        while (cur != null) {
            checkPre = dummy;
            check = dummy.next;
            while (cur.val > check.val) {
                checkPre = check;
                check = check.next;
            }
            checkNext = check.next;
            curNext = cur.next;

            // exchange two nodes
            if (check.next == cur) {
                checkPre.next = cur;
                cur.next = check;
                check.next = curNext;
                cur = curNext;
            } else {
                checkPre.next = cur;
                cur.next = checkNext;
                curPre.next = check;
                check.next = curNext;
                cur = check.next;
            }

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        Insertion_Sort_List_147 s = new Insertion_Sort_List_147();
        ListNode ans = s.insertionSortList(head);
    }
}
