class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // [number, frequency]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            pq.offer(new int[]{ entry.getKey(), entry.getValue() });
        }

        int[] output = new int[k];
        while (k > 0) {
            output[k - 1] = pq.poll()[0];
            k--;
        }

        return output;
    }
}
