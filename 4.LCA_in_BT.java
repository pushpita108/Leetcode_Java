class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //base conditions to stop recursion 
        if(root==null) return null;
        if( root.val == p.val || root.val == q.val ) return root;

        //go to subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // Small runtime betterment - if condition satisfied, it means we already found the LCA 
        if( left != null && left.val != p.val && left.val != q.val ) return left;

        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // check from bottom up, if root has not null elements from both sides, root is LCA
        if( left!= null && right != null ) return root;
        return left==null ? right : left;
    }
}