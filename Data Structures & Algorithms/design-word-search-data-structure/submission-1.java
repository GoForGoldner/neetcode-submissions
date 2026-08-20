class WordDictionary {
    class TrieNode {
        boolean isEnd = false;
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;

        for (char c : word.toCharArray()) {
            // Confused on the best way to add new trienodes
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }

            current = current.children[c - 'a'];
        }

        current.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(root, 0, word);
    }

    public boolean searchHelper(TrieNode current, int i, String word) {
        // Base case
        if (current == null)
            return false;
        if (i == word.length())
            return current.isEnd;

        char c = word.charAt(i);

        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (searchHelper(current.children[j], i + 1, word))
                    return true;
            }
        } else {
            return searchHelper(current.children[c - 'a'], i + 1, word);
        }

        return false;
    }
}
