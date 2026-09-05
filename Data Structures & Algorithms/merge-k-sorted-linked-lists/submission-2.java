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
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Min heap (ascending order)
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );

        // Add lists to min heap
        for (ListNode list : lists) {
            if (list != null) pq.offer(list);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();

            // Set node and shift forward
            current.next = node;
            current = current.next;

            if (node.next != null) pq.offer(node.next);
        }

        return dummy.next;
    }
}
