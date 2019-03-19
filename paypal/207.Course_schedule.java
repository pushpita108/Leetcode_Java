class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        boolean[] visited = new boolean[numCourses];
        boolean[][] adjacent = new boolean[numCourses][numCourses];
        createAdjMatrix(prerequisites, adjacent);

        for( int i=0; i<numCourses; i++){ // as graph might not be connected
            if( !visited[i] ){
                HashSet<Integer> set = new HashSet<>();
                if( dfsHasCycle(adjacent, visited, i, set) ) return false;
            }
        }
        return true;
    }
    
    public void createAdjMatrix(int[][] prerequisites, boolean[][] adjacent){
        for( int i=0; i<prerequisites.length; i++){
            int start = prerequisites[i][0];
            int end = prerequisites[i][1];
            adjacent[start][end] = true;
        }
    }
    
    public boolean dfsHasCycle(boolean[][] adjacent, boolean[] visited, int start, HashSet<Integer> set){
        visited[start] = true; 
        set.add(start);
        for( int i=0; i< adjacent[0].length; i++){
            if( i!= start && adjacent[start][i] ){
                if( set.contains(i) ) return true;
                else{
                    if( !visited[i] && dfsHasCycle(adjacent, visited, i, set) ) return true;
                    else  set.remove(i);
                }
            }
        }
        return false;
    }
}