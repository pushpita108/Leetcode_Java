public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        return quickselect(nums, 0, N - 1, N - k);
    }

    private int quickselect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) { // stop condition, one element remaining 
            return nums[left];
        }

        int pivotIndex = left + new Random().nextInt(right - left); // Use random -> left + rand(right-left)
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (pivotIndex == kSmallest) {
            return nums[pivotIndex];
        } else if (pivotIndex < kSmallest) {
            return quickselect(nums, pivotIndex + 1, right, kSmallest);
        } else {
            return quickselect(nums, left, pivotIndex - 1, kSmallest);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        
        int pivotValue = nums[pivotIndex]; // IMPORTANT
        int storeIndex = left; // IMPORTANT

        swap(nums, pivotIndex, right);
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }
        swap(nums, storeIndex, right);

        return storeIndex;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}