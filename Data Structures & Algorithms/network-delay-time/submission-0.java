class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        k -= 1;

        // Create adjacency list / map
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] t : times) {
            int source = t[0] - 1, target = t[1] - 1, weight = t[2];

            adjList.computeIfAbsent(source, ArrayList::new);
            adjList.get(source).add(new int[]{ target, weight });
        }

        // Setup distances
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k] = 0;

        // int[] = { distance, node }
        // Min heap of distances
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        pq.offer(new int[]{ 0, k });

        while(!pq.isEmpty()) {
            int[] d = pq.poll();
            int distance = d[0], node = d[1];

            // Prevent stale entries
            if (dist[node] < distance) continue;

            for (int[] edge : adjList.getOrDefault(node, Collections.emptyList())) {
                int v = edge[0], w = edge[1];
                if (dist[node] + w < dist[v]) {
                    dist[v] = dist[node] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        System.out.println(Arrays.toString(dist));

        int m = Arrays.stream(dist).max().getAsInt();
        return m == Integer.MAX_VALUE ? -1 : m;
    }
}
