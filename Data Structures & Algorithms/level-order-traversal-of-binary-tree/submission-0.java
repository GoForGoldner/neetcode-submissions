/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        while (!queue.isEmpty()) {

            for (int i = 0, n = queue.size(); i < n; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            output.add(new ArrayList<>(level));
            level.clear();
        }

        return output;
    }
}
