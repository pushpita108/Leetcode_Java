public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }
}

//// below 2 pass - easier to understand ----


class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
                
        //Logic is 
        // a % k = x and b % k = x, then (a-b)%k = 0
        // so we get the sums of indexes till i 
        // get the sum % k
        // store ( (sum % k) , i ) in MAP 
        // if we find any ( sum % k ) already in map with index j-i >= 1, result! 
        
        // simple -> I, J should have same sum % k and I-J >= 1
        
        // 2 pass O(n), O(n)
        if( nums.length == 0 ) return false;
        
        int[] sums = new int[nums.length]; // store sums till i 
        sums[0] = nums[0];
        for( int i=1; i< nums.length; i++){
            sums[i] = sums[i-1] + nums[i];
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // for case like 5 % 6 = 0 !! Just remember 
        for( int i=0; i< nums.length; i++ ){
            int something = sums[i]; // question test cases needed this 
            if( k != 0) { 
                something = sums[i] % k;
            }
            if( map.containsKey(something) ){
                if ( i - map.get(something) > 1) // if condition satisfied return true 
                    return true;
            } else {
                map.put( something, i);
            }
        }
        return false;
    }
}



////// below O(n2)



class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
                
        int[] sums = new int[nums.length]; // sum of numbers till i 
        sums[0] = nums[0];
        
        for( int i=1; i<nums.length; i++){
            sums[i] = sums[i-1] + nums[i];
        }
        
        // so now sum of numbers from index i to j = sums[j]-sums[i]
        
        for( int i=0; i<nums.length; i++){  //n^2
            for( int j=i+1; j<nums.length; j++){
                int sum = sums[j] - sums[i] + nums[i];
                if( sum==k || ( k!=0 && sum%k == 0 ) )
                    return true;
            }
        }
        return false;
    }
}