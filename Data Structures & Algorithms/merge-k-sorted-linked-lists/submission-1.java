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
        ListNode head = new ListNode(-1);
        ListNode current = head;

        // Min heap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            pq.offer(list);
        }

        while(!pq.isEmpty()) {
            ListNode node = pq.poll();

            // Add the child node to the pq
            if (node.next != null) pq.offer(node.next);

            // Add the new node to the list
            current.next = node;
            current = current.next;
        }

        return head.next;
    }
}
