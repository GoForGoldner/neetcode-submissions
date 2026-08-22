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
        List<String> output = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            // Get the index for the entire number
            int j = i + 1;
            while (str.charAt(j) != '#') j++;

            int len = Integer.parseInt(str.substring(i, j));

            int endIndex = j + 1 + len;
            output.add(str.substring(j + 1, endIndex));
            i = endIndex;
        }

        return output;
    }
}
