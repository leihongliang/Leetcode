package algorithm_02_linkedlist;

import javax.swing.event.ListDataEvent;

public class e19_删除链表的倒数第N个结点 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode removeNthFromEnd0(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        ListNode tmp = dummy;
        while ( n-- > 0) {
            fast = fast.next;
        }
        while ( fast != null ) {
            fast = fast.next;
            tmp = slow;
            slow = slow.next;
        }
        tmp.next = slow.next;
        return dummy.next;
    }
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode f = dummy;
        ListNode s = dummy;
        while (n > 0) {
            n--;
            f = f.next;
        }
        while (f.next != null) {
            s = s.next;
            f = f.next;
        }
        s.next = s.next.next;
        return dummy.next;
    }
    //20231003
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while(n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode res = removeNthFromEnd(listNode, 2);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
