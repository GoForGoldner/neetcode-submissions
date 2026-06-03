class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> current = new HashSet<>();

        for (int num : nums) {
            if (current.contains(num)) return true;
            current.add(num);
        }

        return false;
    }
}