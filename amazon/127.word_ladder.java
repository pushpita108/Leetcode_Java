class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet<>(wordList);
        if( !set.contains(endWord) ) return 0;
        
        // do BFS 
        ArrayDeque<String> que = new ArrayDeque<>();
        HashSet<String> visited = new HashSet<>();
        
        int result = 1;
        que.offer(beginWord);
        visited.add(beginWord);
        
        while(!que.isEmpty()){
            
            int size = que.size();
            for( int s=0; s<size; s++) {
                
                String curr = que.remove();
                char[] currArr = curr.toCharArray();
                for( int i=0; i<currArr.length; i++){
                    
                    char c = currArr[i];
                    for(char j='a'; j<='z'; j++){
                        currArr[i] = j;
                        String newStr = new String(currArr);
                        
                        if( newStr.equals(endWord) ) return result+1;
                        
                        if( set.contains(newStr) && !visited.contains(newStr) ){
                            que.offer(newStr);
                            visited.add(newStr);
                        }
                        currArr[i] = c; //restore word 
                    }
                }
            }
            result++; //up one level
        }
        return 0; // not found 
    }
}