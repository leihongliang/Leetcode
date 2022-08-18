package algorithm_02_linkedlist;

public class e142_环形链表2 {
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


    public static ListNode detectCycle(ListNode head) {
        if ( head == null || head.next == null || head.next.next == null ) {
            return null;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while ( fast != slow ) {
            if ( fast.next == null || fast.next.next == null ) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while ( slow != fast && fast != null ) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        ListNode node = new ListNode(3);
        listNode.next.next = node;
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = node;
        ListNode res = detectCycle(listNode);
        System.out.println(res.val);
    }
}
