class UnionFind {
    private int[] parents;
    private int[] rankings;
    int components;

    public UnionFind(int n) {
        parents = new int[n];
        rankings = new int[n];
        components = n;

        // Every node is a parent of itself
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int x) {
        while (x != parents[x]) {
            // Path compression
            parents[x] = parents[parents[x]];
            x = parents[x];
        }

        return x;
    }

    public boolean merge(int x, int y) {
        int fx = find(x), fy = find(y);

        // Cycle detected! They are already linked
        if (fx == fy) return false;

        if (rankings[fx] < rankings[fy]) {
            parents[fx] = fy;
        } else if (rankings[fx] > rankings[fy]) {
            parents[fy] = fx;
        } else {
            rankings[fx]++;
            parents[fy] = fx;
        }

        components--;

        return true;
    }

    public int getComponents() {
        return components;
    }
}

// No duplicate edges will appear

        // Make sure when validating edges that they're no cycles

        // Initial thought is to solve the problem using Union-Find because that determines cycles in undirected graphs

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Base case must have a cycle by definition
        if (edges.length > n - 1) return false;

        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            if (!unionFind.merge(edge[0], edge[1])) return false;
        }

        return unionFind.getComponents() == 1;
    }
}


