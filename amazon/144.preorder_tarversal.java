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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        
        //recursive 
        //helper(root, res);
        
        //iterative
        ArrayDeque<TreeNode> st = new ArrayDeque<>();
        if( root == null ) return res;
        
        st.push(root);
        
        // root -> right -> left in stack 
        while( !st.isEmpty() ){
            TreeNode curr = st.poll();
            res.add( curr.val );
            if( curr.right!=null ) 
                st.push(curr.right);
             if( curr.left!=null ) 
                st.push(curr.left);
         }
        
        
        return res;
    }
    
    public void helper( TreeNode root, List<Integer> res){
        if( root == null ) return;
        
        res.add( root.val );
        helper( root.left, res);
        helper( root.right, res);
     }
}