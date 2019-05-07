class Solution {
    public int countComponents(int n, int[][] edges) {
        
        // create AdjList from array
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        
        boolean[] visited = new boolean[n];
        int cn = 0;
        
        for( int i=0; i<n; i++){
            if( !visited[i] ){
                dfs(adjList, i, visited);
                cn++;
            }
        }
        return cn;
    }
    
    public void dfs(List<List<Integer>> adjList, int start, boolean[] visited){
        visited[start] = true;
        for( int i : adjList.get(start) ){
            if( !visited[i] ){
                dfs( adjList, i, visited);
            }
        }
        
        
    }
}