
class TrieNode {
    boolean isEnd;
    TrieNode[] arr;

    public TrieNode() {
        this.isEnd = false;
        this.arr = new TrieNode[26];

        for (int index = 0; index < 26; index++) {
            this.arr[index] = null;
        }
    }
}

class Trie {
    private TrieNode head;

    public Trie() {
        this.head = new TrieNode();
    }
    
    public void insert(String word) {
        int n = word.length();
        TrieNode curr = this.head;

        for (int index = 0; index < n; index++) {
            int position = word.charAt(index) - 'a';
            if (curr.arr[position] == null) {
                curr.arr[position] = new TrieNode();
            }
            curr = curr.arr[position];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        int n = word.length();
        TrieNode curr = this.head;

        for (int index = 0; index < n; index++) {
            int position = word.charAt(index) - 'a';
            if (curr.arr[position] == null) {
                return false;
            }
            curr = curr.arr[position];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        int n = prefix.length();
        TrieNode curr = this.head;
        for (int index = 0; index < n; index++) {
            int position = prefix.charAt(index) - 'a';
            if (curr.arr[position] == null) {
                return false;
            }
            curr = curr.arr[position];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */