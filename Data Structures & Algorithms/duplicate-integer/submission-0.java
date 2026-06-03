class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numbers = new HashSet<>();

        for (int num : nums) {
            if (numbers.contains(num)) return true;
            numbers.add(num);
        }

        return false;
    }
}