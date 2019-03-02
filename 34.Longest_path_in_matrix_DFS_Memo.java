
//Memorization solution 

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int result = -1;
        // stores the longest length from each cell 
        int[][] cache = new int [matrix.length][matrix[0].length];
        for( int i=0; i< matrix.length; i++){
            for( int j=0; j<matrix[0].length; j++){
                int len = helper( matrix, i, j, cache);
                result = Math.max( result, len);
        }}
        return result;
    }
    public int helper( int[][] matrix, int i, int j, int[][] cache){
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        if( cache[i][j] != 0 ) return cache[i][j]; // base condition 

        //DFS as we have to find the max length
        for(int[] d : dirs){
            int ii = i + d[0];
            int jj = j + d[1];
            
            // invalid conditions 
            // --> writin this way is wrong as stack overflow still occurs !!!!
            // if( ii<0 || ii>=matrix.length || jj<0 || jj>=matrix[0].length || matrix[ii][jj] < matrix[i][j])
            //     continue;
            
            if (ii >=0 && ii < matrix.length && jj>=0 && jj< matrix[0].length && matrix[ii][jj] > matrix[i][j])
                cache[i][j] = Math.max( cache[i][j], helper( matrix, ii, jj, cache) );
        }
        return ++cache[i][j];
    }
}

////////////////////////////////////////////////////////////////////////////////////////

// Without Memorization -> stack overflow 
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int result=-1;
        
        for( int i=0; i< matrix.length; i++){
            for( int j=0; j<matrix[0].length; j++){
                int len = helper( matrix, i, j);
                result = Math.max( result, len);
            }
        }
        return result;
    }
    
    public int helper( int[][] matrix, int i, int j){
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int len = 0 ;
        //DFS as we have to find the max length
        for(int[] d : dirs){
            int ii = i + d[0];
            int jj = j + d[1];
            
            //invalid conditions
            if( ii<0 || ii>=matrix.length || jj<0 || jj>=matrix[0].length || matrix[ii][jj] < matrix[i][j])
                continue;
            
            len = Math.max( len, helper( matrix, ii, jj) );
        }
        return ++len;
    }
}

