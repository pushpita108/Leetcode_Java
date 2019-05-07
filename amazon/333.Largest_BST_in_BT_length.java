/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int largestBSTSubtree(TreeNode root) {
        
        int[] res = helper(root);
        return res[2];
    }
    
    public int[] helper(TreeNode root){
        if( root == null ) // left reached 
            return new int[]{ Integer.MAX_VALUE, // as parent node can still form a BST we need to statisy condition in line 25
                              Integer.MIN_VALUE, 
                              0};
        
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if( root.val > left[1] && root.val < right[0] ){ // if BST
            return new int[]{ Math.min(root.val, left[0]), 
                              Math.max(root.val, right[1]), 
                              left[2]+right[2]+1 };
        }else{
            return new int[]{ Integer.MIN_VALUE, // now parent node cannot become BST, so falsify condition in line 25
                              Integer.MAX_VALUE, 
                              Math.max(left[2], right[2])};
        }
    }
}