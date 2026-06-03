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
        int[] letterCount = new int[26];

        for (char letter : str.toCharArray()) {
            letterCount[letter - 'a']++;
        }

        List<Integer> list = new ArrayList<>();
        for (int num : letterCount) {
            list.add(num);
        }
        return list;
    }
}
