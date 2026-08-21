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

    public List<String> decode(String str) {
        int i = 0;
        List<String> output = new ArrayList<>();

        while (i < str.length()) {
            // Parse until the pound is reached
            int j = i;
            while (str.charAt(j) != '#') j++;

            int len = Integer.parseInt(str.substring(i, j));

            output.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }

        return output;
    }
}
