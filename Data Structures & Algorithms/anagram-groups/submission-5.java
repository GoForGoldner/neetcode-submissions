class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> map = new HashMap<>();

        for (String str : strs) {
            List<Integer> freq = freqencies(str);

            // Add list if empty and add string to list
            map.computeIfAbsent(freq, k -> new ArrayList<>());
            map.get(freq).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private List<Integer> freqencies(String str) {
        List<Integer> output = new ArrayList<>(Collections.nCopies(26, 0));

        for (char c : str.toCharArray()) {
            output.set(c - 'a', output.get(c - 'a') + 1);
        }

        return output;
    }
}
