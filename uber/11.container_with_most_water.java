class Solution {
    public int maxArea(int[] height) {
        
        int end = height.length - 1;
        int start = 0;
        int max = 0;
        
        while(start < end) {
            int x = end - start;
            int y = height[start] > height[end] ? height[end] : height[start];//smaller one
            max = (x*y) > max ? (x*y) : max; // area 
            if (height[start] > height[end]) {
                end --;
            }else{
                start++;
            }
        }
        return max;
    }
}