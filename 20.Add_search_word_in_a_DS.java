class WordDictionary {
    
    class Node {
        Node[] chars;
        boolean isWord;
        
        Node(){
            chars = new Node[26];
            isWord = true;
        }
    };

    Node head;
    /** Initialize your data structure here. */
    public WordDictionary() {
        head = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node temp = head;
        for( char c : word.toCharArray() ){
            if(temp.chars[ c - 'a'] == null ) {
                temp.chars[ c - 'a'] = new Node();
            } 
            temp = temp.chars[ c-'a' ];
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        Node temp = head;
        System.out.println(word);
        return searchHelper(word, 0, temp);
    }
    
    public boolean searchHelper(String word, int index, Node node){
        System.out.println(index);
        if( index == word.length()){ // not -1 to reach the next node for checking isWord 
            return node!=null && node.isWord;
        }
        
        char c = word.charAt(index);

        if( c == '.') {
            boolean result = false;
            for( Node n : node.chars){
                if( n!= null){
                    if(  searchHelper( word, index+1, n) ==  true) {
                        result = true;
                    }
                }
            }
            return result;
        }
        
        if( node.chars[ c - 'a'] != null){
            return searchHelper( word, index+1, node.chars[c-'a']);
        } else {
            return false;
        }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */