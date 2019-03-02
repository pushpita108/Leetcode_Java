class Solution {
    public int climbStairs(int n) {
        if( n == 0 ) return 0;
        if( n == 1) return 1;
        
        // modified fibonacci series ---> series starts with 1 and 2 
        //f[0] = 0
        //f[1] = only 1 way 
        //f[2] = 2 ways ----> diff here
        //f[3] = 3 ways
        //f[4] = 5 
        
        int[] res = new int[n+1]; //n + 1 needed as we dont use res[0]
        //res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for( int i = 3; i<=n; i++){
            res[i] = res[i-1] + res[i-2];
        }
        
        return res[n];
    }
}

//================================= better solution below , understand above =======

class Solution {
    public int climbStairs(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        
        int first=1, second=2;
        for(int i=3; i<=n; i++){
            int third = first + second;
            first = second; 
            second = third;
        }
        
        return second;
    }
}