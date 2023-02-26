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


    public static ListNode detectCycle0(ListNode head) {
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

    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while( slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val);
        return slow;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
        ListNode listNode2 = new ListNode(2);
        listNode.next = listNode2;
        listNode.next.next = new ListNode(0);
        listNode.next.next.next = new ListNode(-4);
        listNode.next.next.next.next = listNode2;
        ListNode res = detectCycle(listNode);
        System.out.println(res.val);
    }
}
