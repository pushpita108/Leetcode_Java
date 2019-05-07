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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        

        /**
         * simple, check if root <= p then search in right
         *  else, search in left or the root(when left is null)
         */

        if( root == null ) return null;
        
        if( root.val <= p.val){ // means succesor is on other side 
            return inorderSuccessor(root.right, p);
        }else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
        
    }
}