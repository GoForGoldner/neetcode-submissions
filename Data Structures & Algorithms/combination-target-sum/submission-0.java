class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        // Same number can be chosen infinite times 
        // Must add up exactly to the target

        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> output = new ArrayList<>();

        combinationHelper(nums, 0, target, 0, combination, output);

        return output;
    }

    private void combinationHelper(
        int[] nums,
        int currentSum, 
        int target, 
        int index, 
        List<Integer> combination, 
        List<List<Integer>> output) {

        // Base cases
        if (currentSum == target) {
            output.add(new ArrayList<>(combination));
            return;
        } else if (currentSum > target) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (currentSum + nums[i] > target) continue;

            combination.add(nums[i]);
            combinationHelper(nums, currentSum + nums[i], target, i, combination, output);
            combination.remove(combination.size() - 1);
        }
    }
}
