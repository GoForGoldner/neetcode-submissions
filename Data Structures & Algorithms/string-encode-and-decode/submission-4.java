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
        int n = str.length();
        List<String> output = new ArrayList<>();

        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (str.charAt(j) != '#') j++;

            int len = Integer.parseInt(str.substring(i, j));
            output.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }

        return output;
    }
}
