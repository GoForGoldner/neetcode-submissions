class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // Create frequency list
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Create bucket list from the freq list
        List<Integer>[] freq = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            freq[i] = new ArrayList<>();
        }

        // Populate the bucket
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] output = new int[k];
        int index = 0;
        for (int i = n; i > 0 && index < k; i--) {
            for (int num : freq[i]) {
                output[index++] = num;
                if (index == k) return output;
            }
        }

        return output;
    }
}
