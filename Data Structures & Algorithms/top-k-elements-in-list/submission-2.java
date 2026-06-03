class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == 0) return new int[]{};

        Map<Integer, Integer> freqMap = new HashMap<>();
        int highestFreq = 0;
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0) + 1;
            
            freqMap.put(num, freq);
            highestFreq = Math.max(highestFreq, freq);
        }

        List<Integer>[] buckets = new ArrayList[highestFreq];
        for (int i = 0; i < highestFreq; i++) buckets[i] = new ArrayList<>();

        for (var entry : freqMap.entrySet()) {
            buckets[entry.getValue() - 1].add(entry.getKey());
        }

        int[] output = new int[k];
        for (int i = highestFreq - 1; i >= 0; i--) {
            List<Integer> bucket = buckets[i];
            while (!bucket.isEmpty()) {
                // Remove any item from the bucket and add it to the output
                output[k - 1] = bucket.remove(bucket.size() - 1);
                if (--k == 0) return output;
            }
        }

        return output;
    }
}
