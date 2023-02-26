package algorithm_02_linkedlist;

public class e07_链表相交 {
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


    public static ListNode getIntersectionNode0(ListNode headA, ListNode headB)  {
        return null;
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB)  {
        ListNode list1 = headA;
        ListNode list2 = headB;
        int a, b, c;
        a = b = c = 0;
        while (list1 != null){
            a++;
            list1 = list1.next;
        }
        while (list2 != null){
            b++;
            list2 = list2.next;
        }
        if (a >= b) {
            c = a - b ;
            list1 = headA;
            list2 = headB;
        }else{
            c = b - a;
            list1 = headB;
            list2 = headA;
        }
        while ( c != 0) {
            list1 = list1.next;
            c--;
        }
        while (list1 != null){
            if(list1 == list2 ){
                return list1;
            }else{
                list1 = list1.next;
                list2 = list2.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);



        ListNode res = getIntersectionNode(listNode1,listNode2);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
