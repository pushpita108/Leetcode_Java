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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> result = new ArrayList<Integer>();
        if( root == null ) return result;
        
        helper( root, result, 0);
        return result;
        
    }
    
    public void helper( TreeNode root, List<Integer> result, int level){
        
        if( root == null ) return;
        if(  level >= 0 && level < result.size() ){
            result.remove( level );
        } 
        result.add( level , root.val );
        helper( root.left, result, level+1);
        helper( root.right, result, level+1);
        
    }
}