class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int rows = matrix.length;
        if( rows == 0) return result;
        int cols = matrix[0].length;
        int i=0, j=0;
        
        while( i< rows && j < cols){
            
            //go to the cols
            for( int c = j; c< cols; c++) result.add( matrix[i][c]);
                
            //go through the rows
            for( int c = i+1; c< rows; c++) result.add( matrix[c][cols-1]);
            
            
             if( i<rows-1 && j<cols-1){
                // go thorugh last of cols
                for( int c=cols-1-1; c>j; c--) result.add( matrix[rows-1][c]);
                // go thorugh last of cols
                for( int c=rows-1; c>i; c--) result.add( matrix[c][i]);
             }
            i++;
            j++;
            rows--;
            cols--;
        }
        
        
        return result;
    }
}