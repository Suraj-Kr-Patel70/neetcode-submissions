class PrefixTree {

    // Trie Node
    class TrieNode {

        TrieNode[] children = new TrieNode[26];

        boolean isEndOfWord = false;
    }

    private TrieNode root;

    // Constructor
    public PrefixTree() {
        root = new TrieNode();
    }

    // Insert a word
    public void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            // Create node if it doesn't exist
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        // Mark end of complete word
        current.isEndOfWord = true;
    }

    // Search complete word
    public boolean search(String word) {

        TrieNode node = findNode(word);

        return node != null && node.isEndOfWord;
    }

    // Check prefix
    public boolean startsWith(String prefix) {

        return findNode(prefix) != null;
    }

    // Find node corresponding to a string
    private TrieNode findNode(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                return null;
            }

            current = current.children[index];
        }

        return current;
    }
}
