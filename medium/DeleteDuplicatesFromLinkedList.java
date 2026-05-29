package medium;

import common.ListNode;

public class DeleteDuplicatesFromLinkedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current!= null && current.next!= null) {
            ListNode nextNode = current.next;
            if (nextNode.val == current.val) {
                current.next = nextNode.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(5);

        ListNode result = deleteDuplicates(head);
        while (result!= null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
