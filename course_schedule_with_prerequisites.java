class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] visited = new int[numCourses];
        boolean[][] adjacent = new boolean[numCourses][numCourses];
        createAdjMatrix(prerequisites, adjacent);

        boolean isCycle = false;
        for( int i=0; i<numCourses; i++){ // as graph might not be connected
            if( visited[i] == 0 ){
                isCycle = dfsHelper(adjacent, visited, i);
                if ( isCycle ) return false;
                visited[i] = 2;
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
    
    public boolean dfsHelper(boolean[][] adjacent, int[] visited, int start){
        System.out.println( start + ", " + visited[start]);
        visited[start] = 1; 
        for( int i=0; i< adjacent[0].length; i++){
            if( i!= start && adjacent[start][i] ){
                System.out.println( start + "-" + i + "=" + adjacent[start][i] + " , " + visited[i]);
                if( visited[i] != 1 ){
                    return dfsHelper( adjacent, visited, i);
                }else if( visited[i] == 1){
                    System.out.println("here");
                    return true;
                }      
            }
        }
         System.out.println("please dont come here");
        return false;
    }
}