class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        for(int i=0; i<(n+1)/2 ; i++){ // n+1 to 
            
            for(int j=0; j<n/2; j++){
                
                //[2][0] left bottom 
                //[2][2] right bottom
                //[0][2] right top
                //[0][0] left top
                int temp = matrix[n-1-j][i]; // go across columns so j in column position
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i]; // go down rows so j in row position
                matrix[j][n-1-i] = matrix[i][j];
                matrix[i][j] = temp;

            }
        }
        
    }
}


// ROTATE AND TRANSPOSE 
class Solution {
    public void reverseColumns(int arr[][]) 
    { 
        for (int i = 0; i < arr[0].length; i++) 
            for (int j = 0, k = arr[0].length - 1; j < k; j++, k--) { 
                int temp = arr[i][j]; 
                arr[i][j] = arr[i][k]; 
                arr[i][k] = temp; 
            } 
    } 
  
    // Function for do transpose of matrix 
    public void transpose(int arr[][]) 
    { 
        for (int i = 0; i < arr.length; i++) 
            for (int j = i; j < arr[0].length; j++) { 
                int temp = arr[j][i]; 
                arr[j][i] = arr[i][j]; 
                arr[i][j] = temp; 
            } 
    } 
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseColumns(matrix);
        
    }
}