class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> freqToList = new HashMap<>();

        for (String str : strs) {
            List<Integer> freq = strToFreq(str);

            freqToList.computeIfAbsent(freq, (i) -> new ArrayList<>());
            freqToList.get(freq).add(str);
        }

        return new ArrayList<>(freqToList.values());
    }

    private List<Integer> strToFreq(String str) {
        List<Integer> freq = new ArrayList<>(Collections.nCopies(26, 0));
        for (char c : str.toCharArray()) {
            freq.set(c - 'a', freq.get(c - 'a') + 1);
        }

        return freq;
    }
}
