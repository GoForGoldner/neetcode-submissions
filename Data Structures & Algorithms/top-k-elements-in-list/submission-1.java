class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqCount = new HashMap<>();
        int maxFreq = 0;

        for (int num : nums) {
            int freq = freqCount.getOrDefault(num, 0) + 1;
            freqCount.put(num, freq);
            maxFreq = Math.max(maxFreq, freq);
        }

        List<Integer>[] buckets = new ArrayList[maxFreq + 1];
        for (int i = 0; i <= maxFreq; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : freqCount.entrySet()) {
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] output = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            for (int num : buckets[i]) {
                output[index++] = num;
                if (index == k) break;
            }
        }

        return output;
    }
}