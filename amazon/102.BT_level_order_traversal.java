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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        inorder(root, result, 0);
        return result;
    }
    
    public void inorder(TreeNode root, List<List<Integer>> result, int level){
        if(root == null) return;
        
        if( result.size() == level ){
            result.add( new ArrayList<Integer>() );
        }
        result.get(level).add(root.val);
        inorder(root.left, result, level+1);
        inorder(root.right, result, level+1);
    }
}