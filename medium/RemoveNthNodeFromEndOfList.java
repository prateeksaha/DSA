package medium;

import common.ListNode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = removeNthFromEnd(head, 2);

        while (result!= null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode t = head;

        while (t != null) {
            t = t.next;
            count++;
        }

        // Remove head case
        if (count == n) {
            return head.next;
        }

        int target = count - n;
        ListNode temp = head;

        for (int i = 1; i < target; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;
    }
}
