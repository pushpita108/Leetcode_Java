class Solution {
  public int search(int[] nums, int target) {
      
      if( nums.length == 0 ) return -1;
      if( nums.length == 1) return nums[0]==target ? 0 : -1; 
      
      int min = searchMin(nums, target);
      
      if( nums[min] == target ) return min;
      
      if( min == 0 ) return binarySearch(nums, 0, nums.length, target);
      else if( target >= nums[0] ) return binarySearch(nums, 0, min, target);
      else return binarySearch(nums, min, nums.length, target);
  }
  
  public int searchMin(int[] nums, int target){
      
      int left = 0, right = nums.length;
      if( nums[left] < nums[right-1]) return 0; // array not rotated
      int mid; 
      
      while( left < right){
          mid = (left + right)/2;
          if( mid == 0 ) return 0; // boundary check 
          
          if( nums[mid] < nums[mid-1]) return mid;
          else if( nums[mid] > nums[left]) left = mid;
          else right = mid;
      }
      return 0;
  }
  
  public int binarySearch(int[] nums, int left, int right, int target){
      int mid; 
      
      while( left < right){
          mid = (left + right)/2;            
          if( nums[mid] == target) return mid;
          else if( nums[mid] > target) right = mid;
          else left = mid+1;
      }
      return -1;
  }
}

///--------------cleaner above --------------------------






class Solution {

    public int binarySearch(int[] nums, int left, int right, int target) {

        while(left < right) {
            int mid = (left + right) /2;
            if( nums[mid] == target ) {
                return mid;
            }
            if( target < nums[mid] ){
                right = nums[mid-1];
            } else {
                left = nums[mid+1];
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        if( nums.length == 1) return -1;
        if( nums.length == 1) {
            return nums[0]==target ? 0 : -1;
        }
        if( nums.length == 2) {
            return nums[0]==target ?0 : nums[1]==target?1 : -1;
        }
        
        //Binary search to find the smallest elemtn 
        int left = 0;
        int right = nums.length;
        int mid;
        while ( true ){
            mid = ( left + right ) /2;
            System.out.println(mid);
            if( nums[mid] < nums[mid-1] ){
                break;
            } else {
                if( nums[mid] < nums[left] ){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        
        //check if target lies in first half or second half or array using num[0] 
        if( target >= nums[0] ) {
            return binarySearch(nums, 0, mid-1 , target);
        } else {
            return binarySearch(nums, mid+1, nums.length-1 , target);
            
        }
    }

    public static void main( String args[]){
        int arr[] = {4,5,6,7,0,1,2};
        Solution s = new Solution();
        
        System.out.println( s.search(arr, 8) );
    }
}

// --------------------------- working --------------------------------


class Solution {
    int [] nums;
    int target;
  
    public int find_rotate_index(int left, int right) {
      if (nums[left] < nums[right])
        return 0;
  
      while (left <= right) {
        int pivot = (left + right) / 2;
        if (nums[pivot] > nums[pivot + 1])
          return pivot + 1;
        else {
          if (nums[pivot] < nums[left])
            right = pivot - 1;
          else
            left = pivot + 1;
        }
      }
      return 0;
    }
  
    public int search(int left, int right) {
      /*
      Binary search
      */
      while (left <= right) {
        int pivot = (left + right) / 2;
        if (nums[pivot] == target)
          return pivot;
        else {
          if (target < nums[pivot])
            right = pivot - 1;
          else
            left = pivot + 1;
        }
      }
      return -1;
    }
  
    public int search(int[] nums, int target) {
      this.nums = nums;
      this.target = target;
  
      int n = nums.length;
  
      if (n == 0)
        return -1;
      if (n == 1)
        return this.nums[0] == target ? 0 : -1;
  
      int rotate_index = find_rotate_index(0, n - 1);
  
      // if target is the smallest element
      if (nums[rotate_index] == target)
        return rotate_index;
      // if array is not rotated, search in the entire array
      if (rotate_index == 0)
        return search(0, n - 1);
      if (target < nums[0])
        // search in the right side
        return search(rotate_index, n - 1);
      // search in the left side
      return search(0, rotate_index);
    }
  }