class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if( root==null ){
            return null;
        }
        if( p.val < root.val && q.val < root.val){
            lowestCommonAncestor(root.left, p, q);
        } else  if( p.val > root.val && q.val > root.val){
            lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }
}