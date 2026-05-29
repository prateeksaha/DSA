package medium;

import common.ListNode;

public class PairWiseSwappingInLinkedList {

    public static void swap(ListNode head) {
        ListNode temp = head;
        while(temp != null && temp.next != null){
            ListNode ptr = temp.next;
            int tempVal = temp.val;
            temp.val = ptr.val;
            ptr.val = tempVal;
            temp = temp.next.next;
        }
    }
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        swap(head);
        printList(head);
    }
}
