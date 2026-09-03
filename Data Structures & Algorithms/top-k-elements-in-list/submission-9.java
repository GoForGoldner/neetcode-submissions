class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // Create a frequency list for all numbers
        // [number, frequency]
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Create a bucket list for each frequency
        // Note: n + 1 to make frequencies easier
        List<Integer>[] buckets = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Populate buckets from frequency map
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        // Traverse in descending order of frequencies until k is satisfied
        int[] output = new int[k];

        for (int i = n; i >= 0; i--) {
            List<Integer> bucket = buckets[i];
            for (int j = 0; j < bucket.size() && k > 0; j++) {
                output[--k] = bucket.get(j); 
            }
        }

        return output;
    }
}
