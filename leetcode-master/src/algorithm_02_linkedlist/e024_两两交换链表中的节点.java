package algorithm_02_linkedlist;


public class e024_两两交换链表中的节点 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }
    }
    public static ListNode swapPairs(ListNode head) {
        if ( head == null || head.next == null ){
            return head;
        }
        ListNode dummy= new ListNode(-1, head);
        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null && cur.next != null) {
            ListNode tmp =  cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next  = tmp;
            pre = cur;
            cur = tmp;

        }
        return dummy.next;
    }
    public static ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null && cur.next.next != null) {
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            cur = node1;
        }
        return dummyHead.next;
    }
    public static ListNode swapPairs3(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            ListNode temp = cur.next.next; // 缓存 next
            pre.next = cur.next;          // 将 prev 的 next 改为 head 的 next
            cur.next.next = cur;          // 将 head.next(prev.next) 的next，指向 head
            cur.next = temp;               // 将head 的 next 接上缓存的temp
            pre = cur;                    // 步进1位
            cur = cur.next;               // 步进1位
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
        ListNode res = swapPairs(listNode);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
