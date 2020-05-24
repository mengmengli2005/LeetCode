package LinkedList;

public class Reverse_Linked_List_II_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-5);
        dummy.next = head;
        ListNode con = dummy, pre = dummy, cur = dummy.next, post = null, tail = null;
        int count = 1;

        while (count <= m && cur != null) {
            con = pre;
            pre = cur;
            cur = cur.next;
            count ++;
        }
        tail = pre;

        while (count <= n && cur != null) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
            count ++;
        }

        con.next = pre;
        tail.next = cur;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode x1 = new ListNode(1);
        x1.next = new ListNode(2);
        x1.next.next = new ListNode(3);
        x1.next.next.next = new ListNode(4);
        x1.next.next.next.next = new ListNode(5);

        Reverse_Linked_List_II_92 s = new Reverse_Linked_List_II_92();
        ListNode output = s.reverseBetween(x1, 2,4);
    }
}
