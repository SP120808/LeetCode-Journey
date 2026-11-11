/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (true) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                }
            }

            if (index == -1)
                break;

            curr.next = lists[index];
            curr = curr.next;
            lists[index] = lists[index].next;
        }

        curr.next = null;
        return dummy.next;
    }
}
