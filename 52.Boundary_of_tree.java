/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

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
    
    public boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }
    
    public void inorder( TreeNode root, List<Integer> result){
        if( root == null ) return;
        
        inorder( root.left, result);
        if( isLeaf(root) ) result.add( root.val );
        inorder( root.right, result);
        
    }
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> result = new LinkedList<>();
        
        //corner cases 
        if( root==null ) return result;
        if( isLeaf(root) ){
            result.add( root.val );
            return result;
        }
        
        //1) add root first 
        result.add(root.val); 
        
        //2) add left side tree path except leaf 
        TreeNode left = root.left;
        while( left!=null ){
            if( !isLeaf(left) ){
                result.add( left.val ); // add into result first 
            }
            
            // traverse the path till end 
            if( left.left!=null ){
                left = left.left; // first check left here
            }else{
                left = left.right;
            } 
        }
        
        //3) add leaves
        inorder( root, result );
        
        
        //4) get right side tree path except leaf 
        TreeNode right = root.right;
        Stack<Integer> st = new Stack<>();
        while( right!=null ){
            if( !isLeaf(right) ){
                st.push( right.val ); // add into result first 
            }
            
            // traverse the path till end 
            if( right.right!=null ){
                right = right.right; // first check right here
            }else{
                right = right.left;
            } 
        }
        
        //5) add the right path in reverse 
        while( !st.empty() ){
            result.add( st.pop() );
        }
        
        return result;
        
    }   
}



 ////// wrong logic below- utterly wrong //////////////


class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        
        List<Integer> result = new LinkedList<>();
        
        //corner cases
        if( root==null ) return result;
        if( root.left==null && root.right==null) {
            result.add(root.val);
            return result;
        }
        
        TreeNode node = root;
        result.add(root.val); // 1) Add root 
        
        while( node!= null && node.left!=null ){ // 2) Traverse left subtree
            node = node.left;
            if( node.left != null || node.right!=null) //not leaf
                result.add( node.val );
        }
        System.out.println("left " + result.size());
        
        helper(root, result); // 3) Traverse all leaf nodes 
System.out.println("leafs " + result.size());
        
        List<Integer> right = new LinkedList<>();
        node = root;
        while( node!= null && node.right!=null ){ // 4) Traverse right subtree
            node = node.right;
            if( node.left != null || node.right!=null) //not leaf
                right.add( node.val );
        }
        System.out.println("right " + right.size());

        // 5) Add the right nodes in reverse order
        while( right.size() > 0 ){
            result.add( (Integer)right.remove( right.size()-1 ) );
        }
        System.out.println( "Right done " + result.size());


        return result;
        
    }
    
    public void helper( TreeNode root, List<Integer> result){
        if( root == null ) return;
        
        helper( root.left, result);
        if( root.left == null && root.right == null){
            result.add( root.val );
        }
        helper( root.right, result);
        
        
    }
    
}