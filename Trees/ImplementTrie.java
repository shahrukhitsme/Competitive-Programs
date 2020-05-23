/*
Question Link: https://leetcode.com/problems/implement-trie-prefix-tree/
Approach: It is a tree link data structure. Each node is a combination of an array of 26 length of same type, and a boolean which tells whether the word has ended.
*/
class TreeNode{
    TreeNode[] letters;
    boolean isEnd;
    TreeNode(TreeNode[] arr, boolean bool){ letters = arr; isEnd = bool; }
    TreeNode(boolean bool){ isEnd = bool; }
}

class Trie {
    TreeNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode(false);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        StringBuilder str = new StringBuilder();
        str.append(word);
        int index;
        TreeNode crawler = root;
        for(int i=0; i<str.length(); i++){
            index = str.charAt(i)-'a';
            if(crawler.letters==null){
                crawler.letters = new TreeNode[26];
            }
            if(crawler.letters[index] == null)
                crawler.letters[index] = new TreeNode(false);
            crawler = crawler.letters[index];
        }
        crawler.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        StringBuilder str = new StringBuilder();
        str.append(word);
        int index;
        TreeNode crawler = root;
        for(int i=0; i<str.length(); i++){
            index = str.charAt(i)-'a';
            if(crawler.letters==null || crawler.letters[index] == null)
                return false;
            crawler = crawler.letters[index];
        }
        return crawler.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        StringBuilder str = new StringBuilder();
        str.append(prefix);
        int index;
        TreeNode crawler = root;
        for(int i=0; i<str.length(); i++){
            index = str.charAt(i)-'a';
            if(crawler.letters==null || crawler.letters[index] == null)
                return false;
            crawler = crawler.letters[index];
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