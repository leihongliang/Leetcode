package algorithm_02_linkedlist;

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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
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
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        ListNode res = removeNthFromEnd(listNode, 1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
