import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.lang.Integer;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        //1. Get the counts for each task 
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : tasks){
            if( !map.containsKey(c)){
                map.put(c, 1);
            } else {
                map.put(c, map.get(c)+1);
            }
        }

        //2. Store all counts in reverse order
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(map.size(), Collections.reverseOrder());
        for(char c : map.keySet()){
            q.add(map.get(c));
        }

        //3. Use queue - fill up with tasks/null for one cycle
        int result = 0;
        while(q.size()!=0){
            //maintain a temp list to re-fill the queue at end of each cycle
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int i=0;

            // For a cycle of n: 
            while( i <= n){
                //pop max element from the queue
                if( !q.isEmpty()) {
                    if(q.peek()==1){
                        q.remove();
                    } else {
                        temp.add(q.remove()-1);
                    }
                }
                // This will also count the "null" values after all unique elements are counted for this cycle 
                result++;

                //check if everything is used up and stop 
                if( q.isEmpty() && temp.size()==0){
                    break;
                }
                i++;
            }
            //Re fill the queue with left over values after every cycle
            for(Integer j : temp){
                q.add(j);
            }
        }
        return result;
    }

    public static void main(String args[]){
        char[] test = {'A','A','A','B','B','B'};
        Solution s = new Solution();
        System.out.println( s.leastInterval(test, 2)) ; 
    }
}