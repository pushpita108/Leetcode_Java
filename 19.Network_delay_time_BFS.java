import java.util.ArrayDeque;
import java.util.Queue;

// N will be in the range [1, 100].
// K will be in the range [1, N].
// The length of times will be in the range [1, 6000].
// All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.

// Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        
        //Iterative BFS 
        Queue<Integer> q = new ArrayDeque<>();
        q.add(K-1); // start from K and traverse // -1 to get the index value

        //Seen nodes
        Boolean[] visited = new Boolean[N];
        visited[K-1] = true; // -1 to get the index value
        int count = 1;
        int time = 0;
        while( q.size() != 0 ) { 
            int node = q.remove() ;
            // if( !visited[node] ) {
                for(int i=0; i<times[0].length; i++){
                    if( !visited[i] && times[node][i] > 0 ){
                        q.add(i);
                        visited[i] = true;
                        count++;
                        time += times[node][i];
                    }
                }
            // }
        }
        return (count != N )? -1 : time;
    }

    public static void main(String args[]){

        int[][] a = {{2,1,1},{2,3,1},{3,4,1}};
        Solution s = new Solution();
        s.networkDelayTime(a, 4, 2);
    }
}