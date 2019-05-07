class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {


        Arrays.sort( nums ); // o(nlogn)
        int n = nums.length;
        List<List<Integer>> result = new ArrayList();

        if( nums.length < 4) return result;

        //4sum
        for( int x=0; x< nums.length; x++ ) {

            //boundary checks
            if( nums[x]+nums[x]+nums[x]+nums[x] > target ) break; // min > target = no result
            if( nums[x]+nums[n-1]+nums[n-2]+nums[n-3] < target) continue; // max < target = no result with first candidate
            //skip same numbers
            if( x>0 && nums[x] == nums[x-1] ) continue;

            //3sum
            for( int i=x+1; i< nums.length; i++ ) {

                //boundary checks
                if( nums[x]+nums[i]+nums[x]+nums[x] > target ) break; // min > target = no result
                if( nums[x]+nums[i]+nums[n-1]+nums[n-2] < target) continue; // max < target = no result with first candidate
                //skip same numbers
                if( i>x+1 && nums[i] == nums[i-1] ) continue;
                int low=i+1, high=nums.length-1;

                while( low < high ){
                    int sum = nums[i] + nums[x] + nums[low] + nums[high];
                    if( sum == target ){
                        List<Integer> set = new ArrayList();
                        set.add(nums[x]);
                        set.add(nums[i]);
                        set.add(nums[low]);
                        set.add(nums[high]);
                        result.add(set);

                        high--; low++;
                        while( low<high && nums[low-1] == nums[low] ) low++;
                        while( low<high && nums[high+1] == nums[high] ) high--;
                    } else if( sum > target ){
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return result;
        
    }
}