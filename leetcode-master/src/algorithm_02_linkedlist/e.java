package algorithm_02_linkedlist;

public class e {
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


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        return null;
    }
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
        ListNode res = removeNthFromEnd(listNode, 2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
