package medium;

import common.ListNode;

public class OddEvenLinkedList {
    public static ListNode oddEvenList(ListNode head) {
        ListNode oddFront = null;
        ListNode oddBack = oddFront;
        ListNode evenFront = null;
        ListNode evenBack = evenFront;
        ListNode current = head;
        int index = 1;
        while(current != null) {
            ListNode next = current.next; // save next before breaking links
            current.next = null;          // sever stale forward pointer
            if (index % 2 !=0){
                if (oddFront == null){
                    oddFront = current;
                    oddBack = oddFront;
                } else {
                    oddBack.next = current;
                    oddBack = oddBack.next;
                }
            } else {
                if (evenFront == null){
                    evenFront = current;
                    evenBack = evenFront;
                } else {
                    evenBack.next = current;
                    evenBack = evenBack.next;
                }
            }
            current = next;
            index++;
        }
        if (oddBack != null) oddBack.next = evenFront;
        if (evenBack != null) evenBack.next = null;
        return oddFront;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = oddEvenList(head);
        while (result!= null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
