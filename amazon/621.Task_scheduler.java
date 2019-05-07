public class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int result=0;
        
        int[] taskCount = new int[26]; //as A-Z
        for( char c : tasks ){
            taskCount[ c - 'A' ]++;
        }
        
        // Populate all unique tasks in PQ - Init 
        PriorityQueue<Integer> queue = new PriorityQueue<>(26, Collections.reverseOrder());
        for( int t : taskCount ){
            if( t > 0){
                queue.add(t);
            }
        }
        
        while( !queue.isEmpty() ){ // go through each task 
            
            int j = 0;
            List<Integer> temp = new ArrayList<>(); // to get the new counts after each interval cycle
            
            while( j <= n ){
                if( !queue.isEmpty() ){
                    if( queue.peek() > 1 ){
                        temp.add(queue.poll()-1); // reduce count and add to temp
                    }else{
                        queue.poll(); // remove
                    }
                }
                
                result++; // also counts idle slots
                if( queue.isEmpty() && temp.size()==0 ) break; // needed as after we are done with all elements of list, we do not want extra idle slots to fill up the last interval 
                
                j++;
            }
            // After each interval, put temp into queue 
            for(int i : temp){
                queue.add(i);
            }
        }
        return result;
    }
}