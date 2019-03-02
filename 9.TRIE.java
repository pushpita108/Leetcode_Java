import java.lang.String;;

class Trie {

    class TrieNode {
        boolean endOfWord;
        TrieNode[] next;

        TrieNode(){
            endOfWord=false;
            next = new TrieNode[26]; // set to null 
        }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode path = root;
        for(char c : word.toCharArray()){
            if( path.next[c - 'a'] == null){
                path.next[c - 'a'] = new TrieNode();
            }
            path = path.next[c - 'a'];
        }
        path.endOfWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode path = root;
        char[] charArr = word.toCharArray();
        int i=0, steps=0;
        while( i < word.length() &&  path.next[ charArr[i] - 'a'] != null){
            path = path.next[ charArr[i] - 'a'];
            i++; steps++;
        }
        return steps==word.length() && path.endOfWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode path = root;
        char[] charArr = prefix.toCharArray();
        int i=0, steps=0;
        while( i < prefix.length() && path.next[ charArr[i] - 'a'] != null){
            path = path.next[ charArr[i] - 'a'];
            i++; steps++;
        }
        return steps==(prefix.length());
    }

    public static void main(String args[]){
        Trie t = new Trie();
        t.insert("heyya");
        System.out.println( t.search("heya"));
        System.out.println( t.search("hi"));
        System.out.println( t.startsWith("he"));
        System.out.println( t.startsWith("i"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */