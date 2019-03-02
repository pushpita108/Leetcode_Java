import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * POINTS : 
 * sort the array 
 * Loop once, skip duplicates, 
 *      two sum - use BINARY SEARCH( two pointers, i=0 j=length ), skip duplicates
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){

            //Avoid the dulicates - skip to the last similar element
            if( i > 0 && nums[i-1] == nums[i]){
                continue;
            }

            int sum = -nums[i];

            //two sum problem now - binary search(2 pointers)
            int a=i+1, b=nums.length-1;
            while( a < b ){
                if( nums[a]+ nums[b] == sum ){
                    //add to result
                    ArrayList<Integer> nos = new ArrayList<>();
                    nos.add(nums[i]); nos.add(nums[a]); nos.add(nums[b]);
                    result.add(nos);
                    a++; b--;

                    //Avoid duplicates here also
                    while( a < b && nums[a-1] == nums[a] ){ a++; }
                    while( a < b && nums[b+1] == nums[b] ){ b--; }

                } else if( nums[a]+ nums[b] > sum ){
                    b--;
                } else {
                    a++;
                }
            } 
        }
        return result;
    }

    public static void main(String args[]){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution s = new Solution();
        List<List<Integer>> res = s.threeSum(nums);
        for( List<Integer> l : res){
            for( Integer i : l){
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
}