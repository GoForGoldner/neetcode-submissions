class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create adjacency list
        Map<Integer, List<int[]>> adjList = buildAdjacencyList(times, n);

        // Run dijkstras
        int[] output = dijkstras(adjList, n, k - 1);

        int m = Arrays.stream(output).max().getAsInt();
        return m == Integer.MAX_VALUE ? -1 : m;
    }

    // Source -> [ Distance, Node ]
    private Map<Integer, List<int[]>> buildAdjacencyList(int[][] times, int n) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] t : times) {
            int source = t[0] - 1, target = t[1] - 1, time = t[2];

            adjList.computeIfAbsent(source, ArrayList::new);
            adjList.get(source).add(new int[]{ time, target });
        }

        return adjList;
    }

    private int[] dijkstras(Map<Integer, List<int[]>> adjList, int n, int k) {
        // Setup output array
        int[] output = new int[n];
        Arrays.fill(output, Integer.MAX_VALUE);
        output[k] = 0;

        // Min heap of distances
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        pq.offer(new int[]{0, k});

        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int dist = t[0], node = t[1];

            // Skip stale entries
            if (output[node] < dist) continue;

            for (int[] edge : adjList.getOrDefault(node, Collections.emptyList())) {
                int w = edge[0], v = edge[1];

                if (output[node] + w < output[v]) {
                    output[v] = output[node] + w;
                    pq.offer(new int[]{output[v], v});
                }
            }
        }

        return output;
    }
}
