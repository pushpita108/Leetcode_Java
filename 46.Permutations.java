class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        
        for(int i : nums){
            combination.add(i); // convert to list
        }
        
        int comb_length = nums.length;
        int start = 0;
        backtrack(result, combination, comb_length, start);
        
        return result;
    }
    
    public void backtrack( List<List<Integer>> result, List<Integer> combination, int comb_length, int start){
        
        if( start == comb_length ){
            result.add( new ArrayList<Integer>(combination) ); // IMP 
        } 
        
        for( int i=start; i<comb_length; i++ ){
            Collections.swap( combination, start, i);
            backtrack(result, combination, comb_length, start+1);
            Collections.swap( combination, start, i);
        }
    }
}