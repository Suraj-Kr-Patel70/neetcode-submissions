class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(root, word, 0);
    }

    private boolean dfs(TrieNode node, String word, int index) {

        if (index == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(index);

        // Normal character
        if (ch != '.') {
            int childIndex = ch - 'a';

            if (node.children[childIndex] == null) {
                return false;
            }

            return dfs(node.children[childIndex], word, index + 1);
        }

        // '.' -> try every possible character
        for (TrieNode child : node.children) {
            if (child != null && dfs(child, word, index + 1)) {
                return true;
            }
        }

        return false;
    }
}