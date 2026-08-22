class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        // Build the freq map
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Create the bucket (size is all possible frequency values)
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            buckets.add(new ArrayList<>());
        }

        // Turn freq map into buckets
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            buckets.get(entry.getValue()).add(entry.getKey());
        }

        int[] output = new int[k];
        
        for (int i = n; i >= 0; i--) {
            List<Integer> bucket = buckets.get(i);

            for (int value : bucket) {
                output[--k] = value;

                if (k == 0) return output;
            }
        }

        return output;
    }
}
