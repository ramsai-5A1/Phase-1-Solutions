
class TrieNode {
    TrieNode[] arr;
    boolean isEnding;
    
    public TrieNode() {
        this.arr = new TrieNode[26];
        this.isEnding = false;
        for (int index = 0; index < 26; index++) {
            this.arr[index] = null;
        }
    }
}


class Trie {
    
    TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insertWord(String word) {
        int n = word.length();
        TrieNode currNode = this.root;
        for (int index = 0; index < n; index++) {
            int position = word.charAt(index) - 'a';
            if (currNode.arr[position] == null) {
                TrieNode newBlock = new TrieNode();
                currNode.arr[position] = newBlock;
            }
            currNode = currNode.arr[position];
        }
        currNode.isEnding = true;
    }

    private boolean helper(String word, int index, int n, TrieNode currNode) {
        if (index == n) {
            return currNode.isEnding;
        }

        if (word.charAt(index) != '.') {
            int position = word.charAt(index) - 'a';
            if (currNode.arr[position] == null) {
                return false;
            }

            return helper(word, index + 1, n, currNode.arr[position]);
        }

        for (int position = 0; position < 26; position++) {
            if (currNode.arr[position] != null && helper(word, index + 1, n, currNode.arr[position])) {
                return true;
            }
        }
        return false;
    }
    
    public boolean searchWord(String word) {
        int n = word.length();
        return helper(word, 0, n, this.root);
    }
}



class WordDictionary {

    Trie trie;

    public WordDictionary() {
        this.trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insertWord(word);
    }
    
    public boolean search(String word) {
        return trie.searchWord(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */