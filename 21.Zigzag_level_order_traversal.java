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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper( root, 0, res);
        return res;
        
    }
    
    public void helper(TreeNode root, int level, List<List<Integer>> res){
        if(root == null) return;
        
        if( res.size() <= level ){
            res.add(level, new ArrayList<Integer>());
        }
        
        List<Integer> list = res.get(level);
        // System.out.println(root.val);
        if( level%2 == 0 ){
            list.add(root.val);
        }else {
            list.add(0, root.val);
        }
        helper(root.left, level+1, res);
        helper(root.right, level+1, res);
    }
}