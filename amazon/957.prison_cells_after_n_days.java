class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        while( N > 0){
            int[] temp = new int[8];
            
            map.put( Arrays.toString(cells), N-- ); // as this is th first round so reduce N 
            
            for( int j=1; j<7; j++){
                temp[j] = cells[j-1]==cells[j+1] ? 1 : 0; // check with old array
            }
            
            cells = temp;
            
            if( map.containsKey( Arrays.toString(cells) )){
                N %= map.get(Arrays.toString(cells))-N ; // as we are storing N/N-- 
            }
        }
        
        return cells;
        
    }
}