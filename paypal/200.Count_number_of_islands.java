class Solution {
    public int numIslands(char[][] grid) {
        
        if( grid == null || grid.length == 0 ) return 0;
        int result=0;
        
        for( int i=0; i<grid.length; i++){
            for( int j=0; j<grid[0].length; j++){
                if( grid[i][j] == '1'){
                    result++; //found start
                    dfs(grid, i, j); // reach out to all 1s reachable from here and make them 0
                }
            }
        }
        return result;
    }
    
    public void dfs(char[][] grid, int i, int j){
        
        if( i<0 || i>=grid.length || j<0 || j>=grid[0].length ) return; // corner cases
        if( grid[i][j] == '0') return; // our stop criteria
        
        grid[i][j] = '0'; // make this visited place 0
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
    
    
}