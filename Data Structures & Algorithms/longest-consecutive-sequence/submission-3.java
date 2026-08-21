class Solution {
    // [2,20,4,10,3,4,5]
    // Sorted: [2,3,4,4,5,10,20]
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;

        // Sort the array (ascending order)
        Arrays.sort(nums);

        int max = 0;
        int count = 0;

        int prev = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] == prev) {
                continue;
            } else if (nums[i] == prev + 1) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }

            prev = nums[i];
        }

        max = Math.max(max, count);

        // NOTE: the reason it's max + 1 is because we're not keeping track of the first number in the count (we we're only counting consecutives after that)
        return max + 1;
    }
}
