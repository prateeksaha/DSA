package medium;

import common.ListNode;

import java.util.HashSet;
import java.util.Set;

// Removed numbers that are duplicates from a linked list while keeping the original order of the elements.
public class DeleteDuplicatesFromLinkedList2 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        Set<Integer> s = new HashSet<>();
        while(current != null && current.next != null){
            ListNode nextNode = current.next;
            if (current.val == nextNode.val){
                current.next = nextNode.next;
                s.add(current.val);
            } else {
                current = current.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        ListNode temp = head;
        while(temp != null){
            if (!s.contains(temp.val)){
                result.next = temp;
                result = result.next;
            }
            temp = temp.next;
        }
        result.next = null;
        return dummy.next;

    }
}
// This is working solution , proved submitted in Leetcode platform.
// workes under 2ms