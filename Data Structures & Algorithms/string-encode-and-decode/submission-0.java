class Solution {

    public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();

        for (String str : strs) {
            output.append(encodeString(str));
        }

        return output.toString();
    }

    private String encodeString(String str) {
        return str.length() + "#" + str;
    }

    public List<String> decode(String str) {
        List<String> output = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int len = Integer.parseInt(str.substring(i, j));

            output.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }

        return output;
    }
}
