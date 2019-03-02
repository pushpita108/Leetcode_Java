class Solution {
    public void setZeroes(int[][] matrix) {
        
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        
        // Find all cells with 0 
        for( int i=0; i< matrix.length; i++){
            for( int j=0; j< matrix[0].length; j++){
                if( matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        
        for( int i=0; i< matrix.length; i++){
            for( int j=0; j< matrix[0].length; j++){
                if( rows.contains(i) || cols.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }

        
//         // Make all rows zero first
//         Iterator ri = rows.iterator();
//         while( ri.hasNext() ){
//             int row = (int)(ri.next());
//             System.out.println(row);
//             for( int j=0; j< matrix[0].length; j++ ){
//                 matrix[row][j] = 0;
//             }
//         }
        
//         //Make columns zero 
//         Iterator ci = cols.iterator();
//         while( ci.hasNext() ){
//             int col = (int)(ci.next());
//             for( int i=0; i< matrix.length; i++ ){
//                 matrix[i][col] = 0;
//             }
//         }
    }
}