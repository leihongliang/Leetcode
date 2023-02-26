package algorithm_02_linkedlist;

import java.util.Stack;

public class e206_反转链表 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     *  1.stack
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        Stack<ListNode> stack = new Stack<>();
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = stack.pop();
        ListNode res = cur;
        while( !stack.isEmpty() ) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return res;
    }
    /**
     *  2.two points
     */
    public static ListNode reverseList2(ListNode head) {
        if ( head == null || head.next == null ){
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp = null;
        while (cur != null){
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static ListNode reverseList3(ListNode head){
        return reverse(null, head);
    }
    private static ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = null;
        temp = cur.next;// 先保存下一个节点
        cur.next = prev;// 反转
        // 更新prev、cur位置
        // prev = cur;
        // cur = temp;
        return reverse(cur, temp);
    }
    public static ListNode reverseList4(ListNode head) {
        // 边缘条件判断
        if(head == null) return null;
        if (head.next == null) return head;

        // 递归调用，翻转第二个节点开始往后的链表
        ListNode last = reverseList4(head.next);
        // 翻转头节点与第二个节点的指向
        head.next.next = head;
        // 此时的 head 节点为尾节点，next 需要指向 NULL
        head.next = null;
        return last;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        ListNode res = reverseList4(listNode);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
