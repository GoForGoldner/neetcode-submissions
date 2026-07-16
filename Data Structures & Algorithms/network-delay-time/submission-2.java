class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create adjacency list
        Map<Integer, List<int[]>> adjList = buildAdjacencyList(times, n);

        // Run dijkstras algorithm
        int[] shortestPaths = dijkstra(adjList, n, k - 1);

        int m = Arrays.stream(shortestPaths).max().getAsInt();
        return m == Integer.MAX_VALUE ? -1 : m;
    }

    public Map<Integer, List<int[]>> buildAdjacencyList(int[][] times, int n) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] t : times) {
            int source = t[0] - 1, target = t[1] - 1, time = t[2];

            adjList.computeIfAbsent(source, ArrayList::new);
            adjList.get(source).add(new int[]{ time, target });
        }

        return adjList;
    }

    public int[] dijkstra(Map<Integer, List<int[]>> adjList, int n, int k) {
        int[] output = new int[n];
        Arrays.fill(output, Integer.MAX_VALUE);
        output[k] = 0;

        // Min heap of distances
        // [Distance, Node]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        pq.offer(new int[]{ 0, k });

        while(!pq.isEmpty()) {
            int[] edge = pq.poll();
            int distance = edge[0], node = edge[1];

            // Skip stale entries
            if (output[node] < distance) continue;
    
            for (int[] t : adjList.getOrDefault(node, Collections.emptyList())) {
                int w = t[0], v = t[1];
                if (output[node] + w < output[v]) {
                    output[v] = output[node] + w;
                    pq.offer(new int[]{ output[v], v });
                }
            }
        }

        return output;
    }
}
