
 
class Solution {
    // Definition for a binary tree node.
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    };

    public boolean isValidBST(TreeNode root) {
        //multiple cases 
        if( root == null ) return true;
        return bstHelper(root, null, null);
    }
    
    public boolean bstHelper( TreeNode root, Integer min, Integer max){
        if( min!= null && root.val <= min ) return false;
        if( max != null && root.val >= max ) return false;
        
        //first check left 
        boolean left = root.left!=null ? bstHelper(root.left, min, root.val) : true; //change max 
        if( left == false) return false;
        
        //if left is valid check right
        boolean right = root.right!= null ? bstHelper(root.right, root.val, max) : true; //change min
        return right;
    } 

    public static void main( String args[] ){
        Solution s = new Solution();
        s.TreeNode a = new s.TreeNode(5);
        s.TreeNode a1 = new s.TreeNode(2);
        s.TreeNode a2 = new s.TreeNode(8);
        a.left = a1; a.right = a2;
        s.TreeNode a3 = new s.TreeNode(1);
        s.TreeNode a4 = new s.TreeNode(4);
        a1.left = a3; a1.right = a4;
        s.TreeNode a5 = new s.TreeNode(7);
        a2.left = a5;
        System.out.println( s.isValidBST(a) );
    }
}