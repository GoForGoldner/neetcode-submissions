class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> freqMap = new HashMap<>();

        for (String str : strs) {
            List<Integer> freqList = toFreqList(str);

            freqMap.computeIfAbsent(freqList, k -> new ArrayList<>());
            freqMap.get(freqList).add(str);
        }

        return new ArrayList<>(freqMap.values());
    }

    private List<Integer> toFreqList(String str) {
        List<Integer> output = new ArrayList(Collections.nCopies(26, 0));

        for (char c : str.toCharArray()) {
            output.set(c - 'a', output.get(c - 'a') + 1);
        }

        return output;
    }
}
