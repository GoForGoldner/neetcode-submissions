class UnionFind {
    private int[] parents;
    private int[] rankings;
    private int components;

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

        if (fx == fy) return false;

        if (rankings[fx] < rankings[fy]) {
            parents[fx] = fy;
        } else if (rankings[fx] > rankings[fy]) {
            parents[fy] = fx;
        } else {
            parents[fy] = fx;
            rankings[fx]++;
        }

        components--;

        return true;
    }

    public int getComponents() {
        return components;
    }
}

public class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            unionFind.merge(edge[0], edge[1]);
        }

        return unionFind.getComponents();
    }
}
