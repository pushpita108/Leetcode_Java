class Solution {
    public int monotoneIncreasingDigits(int N) {

        
        char[] arr = String.valueOf(N).toCharArray();
        
        int mark = arr.length+1;
        
        // go from back to front - Imp!!!!
        for(int i=arr.length-1; i>0; i--){ // find first decreasing place from start 
            
            if( arr[i-1] > arr[i] ){
                mark = i;
                arr[i-1]--;
            }
        }
        
        for(int i=mark; i<arr.length; i++){ //make all numbers 9 from after(including) 'mark'
            arr[i] = '9';
        }
        
        return Integer.parseInt( new String(arr) );
    }
}