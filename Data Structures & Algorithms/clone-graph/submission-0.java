/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Integer, Node> nodeMap = new HashMap<>();
        return cloneGraphHelper(nodeMap, node);
    }

    private Node cloneGraphHelper(Map<Integer, Node> nodeMap, Node node) {
        Node mapNode = nodeMap.get(node.val);

        if (mapNode == null) {
            // Create a new node and put into cache
            mapNode = new Node(node.val);
            nodeMap.put(node.val, mapNode);

            // Create or add neighboring nodes
            for (Node neighbor : node.neighbors) {
                mapNode.neighbors.add(cloneGraphHelper(nodeMap, neighbor));
            }

        }

        return mapNode;
    }
}