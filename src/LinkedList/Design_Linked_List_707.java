package LinkedList;

public class Design_Linked_List_707 {
    ListNode dummy, head, tail;

    /** Initialize your data structure here. */
    public Design_Linked_List_707() {
        dummy = new ListNode(-5);
        head = null;
        tail = null;
        dummy.next = tail;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        ListNode cur = dummy.next;
        while (index-- > 0 && cur != null) {
            cur = cur.next;
        }
        return index == 0 ? cur.val : -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode tmp = dummy.next;
        dummy.next = new ListNode(val);
        dummy.next.next = tmp;
        if (tmp == null) {
            tail = dummy.next;
        }
        head = dummy.next;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        ListNode pre = dummy, cur = dummy.next;
        while (index-- > 0 && cur != null) {
            pre = cur;
            cur = cur.next;
        }
        if (index == 1) {
            tail.next = new ListNode(val);
            tail = tail.next;
        } else if (index == 0) {
            pre.next = new ListNode(val);
            pre.next.next = cur;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        ListNode pre = dummy, cur = dummy.next;
        while (index-- > 0 && cur != null) {
            pre = cur;
            cur = cur.next;
        }
        if (index > 0) return;
        if (cur.next == null) {
            pre.next = null;
            tail = pre;
        } else {
            pre.next = cur.next;
        }
    }

    public static void main(String[] args) {
        Design_Linked_List_707 x = new Design_Linked_List_707();
        x.addAtHead(1);
        x.addAtTail(3);
        x.addAtIndex(1, 2);
        int out1 = x.get(1);
        x.deleteAtIndex(1);
        int out2 = x.get(1);
    }
}
