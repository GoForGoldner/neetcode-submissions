class Solution {
    // Questions I don't get. 
    // 1. Why is the size of the freq list n + 1?
    // The size of nums in the question is from -1000 to 1000 so I'm confused.

    // 2. why does the index < k have to be inside the for loop? 
    // Won't it just break when index == k?

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // Create frequency list
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Create bucket list for each frequency level
        List<Integer>[] freq = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            freq[i] = new ArrayList<>();
        }

        // Populate the buckets
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] output = new int[k];
        int index = 0;

        // Iterate from the largest frequencies to the smallest
        for (int i = n; i > 0; i--) {
            // Populate the output list for each frequency number.
            for (int num : freq[i]) {
                output[index++] = num;
                if (index == k) return output;
            }
        }

        return output;
    }
}
