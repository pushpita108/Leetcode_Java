class Solution {
    public int fib(int N) {
        
        // fibonacci series  starts from 0 till N( not N-1), so array needed of N+1
        
        if( N == 0) return 0;
        if( N == 1) return 1;
        
        //i can take space of N
        int[] res = new int[N+1];
        res[0] = 0;
        res[1] = 1;
        for( int i = 2; i<=N; i++){
            res[i] = res[i-1] + res[i-2];
        }
        
        return res[N];
        
    }
}

// Can be doen without extra space also by taking 2 variables instead, 
// as for this problem we do not need the value at each cell