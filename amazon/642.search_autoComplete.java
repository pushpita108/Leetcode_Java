class AutocompleteSystem {
        
    class TrieNode{
        boolean isWord;
        HashMap<Character, TrieNode> next;
        PriorityQueue<String> sentences;
        TrieNode(){
            isWord = false;
            next = new HashMap<>();
            sentences = new PriorityQueue<>( (a,b) -> {
                if( map.get(b) == map.get(a) ) {
                    return a.compareTo(b);
                } else {
                    return map.get(a) - map.get(b);
                }
            });
        }
    }
    
    class Trie{
        TrieNode head;
        Trie(){
            head = new TrieNode();
        }
        
        public void add(String s){
            TrieNode curr = head;
            for(char c : s.toCharArray() ){
                if( !curr.next.containsKey(c) ){
                    curr.next.put( c, new TrieNode() );
                }else{
                    if( curr.sentences.size() == 3 ){
                        curr.sentences.poll();
                    }
                }
                curr.sentences.offer(s);
                curr = curr.next.get(c);
            }
            curr.isWord = true;
        }
        
        public PriorityQueue<String> find(String s){
            TrieNode curr = head;
            
            for(char c : s.toCharArray() ){
                if( !curr.next.containsKey(c) ) return null;
                curr = curr.next.get(c);
            }
            if( curr == null  ) return null;
            else return curr.sentences;
        }
        
    }
    
    HashMap<String, Integer> map;
    Trie wordTree;
    String searchKey;
    
    public AutocompleteSystem(String[] sentences, int[] times){
        searchKey = "";
        
        map = new HashMap<>();
        for( int i=0; i<sentences.length; i++){
            map.put( sentences[i], times[i] );
        }
        
        wordTree = new Trie();
        for(String s : sentences){
            wordTree.add(s);
        }
    }
    
    public List<String> input(char c) {
        if( c == '#'){
            map.put( searchKey, map.getOrDefault(searchKey, 0)+1 );
            wordTree.add(searchKey);
            searchKey = "";
            return new ArrayList<>();
        }
        
        searchKey += c;
        PriorityQueue<String> pq = wordTree.find(searchKey);
        
        if( pq == null ) return new ArrayList<>();

        List<String> res = new ArrayList<String>();
        while( !pq.isEmpty() ){
            res.add(pq.poll());
        }
        Collections.reverse( res );
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */