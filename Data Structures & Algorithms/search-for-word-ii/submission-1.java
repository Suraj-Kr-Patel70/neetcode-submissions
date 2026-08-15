

class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word; // stores complete word
    }

    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        // 1. Build Trie
        for (String word : words) {
            insert(word);
        }

        // 2. DFS from every cell
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root);
            }
        }

        return result;
    }

    private void insert(String word) {

        TrieNode curr = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }

            curr = curr.children[index];
        }

        curr.word = word;
    }

    private void dfs(char[][] board, int row, int col, TrieNode node) {

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return;
        }

        char ch = board[row][col];

        // Already visited
        if (ch == '#') {
            return;
        }

        // Character doesn't exist in Trie
        int index = ch - 'a';

        if (node.children[index] == null) {
            return;
        }

        TrieNode next = node.children[index];

        // Found a complete word
        if (next.word != null) {
            result.add(next.word);

            // Prevent duplicate result
            next.word = null;
        }

        // Mark current cell as visited
        board[row][col] = '#';

        // Up
        dfs(board, row - 1, col, next);

        // Down
        dfs(board, row + 1, col, next);

        // Left
        dfs(board, row, col - 1, next);

        // Right
        dfs(board, row, col + 1, next);

        // Backtracking
        board[row][col] = ch;
    }
}