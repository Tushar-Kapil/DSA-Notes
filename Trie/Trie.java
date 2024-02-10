package Trie;

class TrieNode {
    char data;
    TrieNode[] children = new TrieNode[26];
    boolean isTerminal;

    TrieNode(char data) {
        this.data = data;
        for (int i = 0; i < 26; i++) {
            children[i] = null;
        }
        isTerminal = false;
    }
}

public class Trie {
    private TrieNode root;

    Trie() {
        root = new TrieNode('\0');
    }

    private void insertUtil(String word, TrieNode root) {
        // word found check for terminal and return
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }

        // calculate postion of word in array
        int index = word.charAt(0) - 'A';
        TrieNode child;

        // present
        if (root.children[index] != null) {
            child = root.children[index];

        }
        // absent
        else {
            child = new TrieNode(word.charAt(0));
            root.children[index] = child;
        }

        insertUtil(word.substring(1), child);
    }

    public void insertWord(String word) {
        insertUtil(word, root);
    }

    private boolean searchUtil(TrieNode root, String word) {
        if (word.length() == 0) {
            return root.isTerminal;
        }

        int index = word.charAt(0) - 'A';
        TrieNode child;

        if (root.children[index] != null) {
            child = root.children[index];
        } else {
            return false;
        }

        return searchUtil(child, word.substring(1));
    }

    public boolean searchWord(String word) {
        return searchUtil(root, word);
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.insertWord("AB");
        System.out.println(t.searchWord("ABC"));
        System.out.println(t.searchWord("AB"));
    }
}
