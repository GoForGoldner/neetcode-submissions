class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(encodeStr(str));
        }

        return sb.toString();
    }

    private String encodeStr(String str) {
        return str.length() + "#" + str;
    }

    // 4#Test2#hi10#aaaaaaaaaa

    public List<String> decode(String str) {
        int n = str.length();
        List<String> output = new ArrayList<>();

        int i = 0;
        while (i < n) {
            // Get endpoint of number
            int j = i + 1;
            while (str.charAt(j) != '#') j++; 

            int length = Integer.parseInt(str.substring(i, j));
            String word = str.substring(j + 1, j + 1 + length);
            output.add(word);

            i = j + 1 + length;
        }

        return output;
    }
}
