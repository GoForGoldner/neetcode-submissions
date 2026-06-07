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

        // Min heap of listnodes
        PriorityQueue<ListNode> nodes = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            nodes.offer(list);
        }

        while (!nodes.isEmpty()) {
            // Add the new node to the list
            ListNode node = nodes.poll();
            current.next = node;
            current = current.next;

            // Offer new node to the min heap
            if (node.next != null) nodes.offer(node.next);
        }

        return head.next;
    }
}
