/**
 *  DFS with TRIE 
 *  Make char = # to mark cell visited 
 *  Store the word string in TRIE instead of isWord, so no need to backtrack
 */

class Solution {
    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word = null;
    }
    
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void add(String word){
            TrieNode curr = root;
            for(char c : word.toCharArray()){
                if (curr.next[c - 'a'] == null) curr.next[ c - 'a' ] = new TrieNode(); // so that filled node doesn't get replaced later on
                curr = curr.next[ c - 'a' ];
            }
            curr.word = word;
        }
        public TrieNode buildTrie(String[] words){
            for( String w : words){
                add(w);
            }
            return root;
        }
    }
    
    public void dfs(char[][] board, int i, int j, TrieNode root, List<String> result){
        
        if(i<0 || j<0 || i>=board.length || j>=board[0].length ) return;
        
        char c = board[i][j];
        if( c=='#' || root.next[c-'a']==null ) return;
        
        root = root.next[c-'a'];
        if( root.word != null) {
            result.add(root.word); // we dont need to backtack the word
            root.word = null; //to avoid duplicate words in result
        }
        
        board[i][j] = '#';
        dfs(board, i+1, j, root, result);
        dfs(board, i, j+1, root, result);
        dfs(board, i-1, j, root, result);
        dfs(board, i, j-1, root, result);
        board[i][j] = c; // we set the baord back to search again, duplicate searches are stopped above 
    
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        if( words==null || words.length==0 || board==null || board.length==0 ) return result;
        
        Trie tri = new Trie();
        TrieNode root = tri.buildTrie(words);
        
        for( int i=0; i<board.length; i++){
            for( int j=0; j<board[0].length; j++){
                dfs(board, i, j, root, result);
            }
        }
        return result;    
    }
}