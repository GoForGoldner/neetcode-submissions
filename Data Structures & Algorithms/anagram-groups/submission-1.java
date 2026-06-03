class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<List<Integer>, List<String>> outputMap = new HashMap<>();

        for (String str : strs) {
            List<Integer> letterCount = letterCount(str);
            outputMap.computeIfAbsent(letterCount, k -> new ArrayList<>());
            outputMap.get(letterCount).add(str);
        }

        return new ArrayList<>(outputMap.values());
    }

    public List<Integer> letterCount(String str) {
        Integer[] letterCount = new Integer[26];
        Arrays.fill(letterCount, 0);

        for (char letter : str.toCharArray()) {
            letterCount[letter - 'a']++;
        }

        return Arrays.asList(letterCount);
    }
}
