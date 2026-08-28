class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // Make a freq map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Turn it into buckets
        List<Integer>[] buckets = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Turn freq map into buckets
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] output = new int[k];
        // Iterate from the most freq in the buckets and return that many
        for (int i = n; i > 0 && k > 0; i--) {
            for (int num : buckets[i]) {
                output[--k] = num;
            }
        }

        return output;
    }
}
