class Solution {
    public String countAndSay(int n) {
        
        // start 
        if( n == 1 ) return "1";
        
        char[] arr = ("1").toCharArray();
        
        for(int i=1; i<n; i++){ // start counts as 1 time
            StringBuilder res = new StringBuilder();
            int theCount=1;
            int j=0;
            while( j<arr.length ){
                if( j==arr.length-1 ) { // edge case 
                    res.append(theCount+""+ arr[j] );
                } else {
                    if( arr[j] != arr[j+1] ){
                        res.append(theCount+""+ arr[j] );
                        theCount = 1;
                    } else {
                        theCount++;
                    }
                }
                j++;
            }
            arr = res.toString().toCharArray();
        }
        return new String(arr);
    }
}