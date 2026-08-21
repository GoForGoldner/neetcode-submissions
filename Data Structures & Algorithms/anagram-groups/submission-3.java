class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            List<Integer> freq = strToFreq(str);
            anagramMap.computeIfAbsent(freq, k -> new ArrayList<>());
            anagramMap.get(freq).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

    private List<Integer> strToFreq(String str) {
        List<Integer> output = new ArrayList<>(Collections.nCopies(26, 0));

        for (char c : str.toCharArray()) {
            // Increase amount in list
            output.set(c - 'a', output.get(c - 'a') + 1);
        }

        return output;
    }
}
