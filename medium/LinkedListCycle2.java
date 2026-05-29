package medium;

import common.ListNode;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {

        ListNode point = detect(head);
        //System.out.println(point.val);
        ListNode slow = head;
        ListNode fast = point;
        if (point == null){
            return null;
        }
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode detect(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
