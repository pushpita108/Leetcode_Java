class Solution {
    public int uniquePaths(int m, int n) {
        
        //DP solution - base case = first row and first column cells can have only one way to reach
        // for any other cells, no of ways it can be reached is = cell above it + cell to left of it 
        
        // Similar problems 
        // fibonacci series 509
        // climbing stairs 70
        // decode ways 91
        
        int[][] grid = new int[m][n];
        
        for( int i=0; i<m ; i++){
            for( int j=0; j<n; j++){
                if( i==0 || j==0) grid[i][j] = 1; // base case, first row and first column
                else grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
        return grid[m-1][n-1];
    }
}