class Solution {
    public int maxPoints(int[][] points) {
        
        if(points==null || points.length==0 ) return 0;
        if(points.length==1 ) return 1;
        
        int result = 0;
        
        for( int i=0; i<points.length; i++){
            HashMap<Double, Integer> slopes = new HashMap<>();
            int same = 0;
            int parallel = 1;
            
            for( int j=0; j<points.length; j++){
                
                if(j!=i){
                    if(isSamePoint(points, i, j)) same++; // same numbers will also be counted as parallel
                    if(inSameY(points, i, j)) {
                        parallel++;
                        continue; // important!!!  if a points is same=> parrallel, do not find slope
                    }
                    
                    double sl = slope(points, i, j);
                    slopes.put(sl, slopes.getOrDefault(sl,1)+1 );
                    
                    result = Math.max(result, slopes.get(sl)+same ); // counting duplicate points with 'same'
                }
            }
            result = Math.max(result, Math.max(same, parallel) ); // get max of same or parrel nos, to handle all cases
        }
        
        return result;
    }
    
    public boolean isSamePoint(int[][] points, int a, int b){
        return points[a][0]==points[b][0] && points[a][1]==points[b][1];
    }
    
    public boolean inSameY(int[][] points, int a, int b){
        return points[a][1]==points[b][1];
    }
    
    public double slope(int[][] points, int a, int b){
        return (double)(points[a][0] - points[b][0])/
               (double)(points[a][1] - points[b][1]);
    }
}