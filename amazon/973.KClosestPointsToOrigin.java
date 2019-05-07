class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        quicksort(points, 0, points.length-1, K);                                           
        return Arrays.copyOfRange(points, 0, K);
    }
    
    public void quicksort(int[][] points, int i, int j, int K){
        if( i>=j ) return;
        
        int mid = partition(points, i, j);
        int noOfNumsToLeft = mid - i - 1;
        
        if(noOfNumsToLeft == K) return;
        else if( noOfNumsToLeft > K) quicksort(points, i, mid-1 , K);
        else quicksort(points, mid+1, j, K-noOfNumsToLeft); // because i need not sort these k elements
    } 
    // 10 8
    public int partition(int[][] points, int i, int j){
        
        int low = i, high = j;
        
        swap(points, i, j); // 8 10
        while( true ){
            while( low<high && dist(points,low) <= dist(points,j) ) low++;
            while( low<high && dist(points,high) > dist(points,j) ) high--;
            if( low >= high) break;
            swap(points, low, high);
        }
        
        swap(points, i, high);
        return high;
        
    }
    
    public void swap(int[][] points, int i, int j){
        int t0 = points[i][0];
        int t1 = points[i][1];
        
        points[i][0] = points[j][0];
        points[i][1] = points[j][1];
        
        points[j][0] = t0;
        points[j][1] = t1;
    }
    
    public int dist(int[][] points, int a){
        return points[a][0]*points[a][0] + points[a][1]*points[a][1];
    }
}