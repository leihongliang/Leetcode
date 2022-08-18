package algorithm_02_linkedlist;

public class e203_移除链表元素 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(1);
        dummy.next = head;
        ListNode cur = dummy;
        while ( cur != null){
            if ( cur.next == null){
                break;
            }
            if ( cur.next.val == val ){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static ListNode removeElements2(ListNode head, int val) {
        ListNode dummy = new ListNode(1, head);
        dummy.next = head;
        ListNode cur = dummy;
        while ( cur.next != null ){
            if ( cur.next.val == val ){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }


    public static ListNode removeElements3(ListNode head, int val) {
        ListNode dummy = new ListNode(1, head);
        ListNode cur = head;
        ListNode pre = dummy;
        while ( cur != null ){
            if ( cur.val == val ){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(7);
        listNode.next.next.next = new ListNode(1);
//        listNode = removeElements(listNode, 7);
//        ListNode res = removeElements2(listNode, 7);
        ListNode res = removeElements3(listNode, 7);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }

    }

}
