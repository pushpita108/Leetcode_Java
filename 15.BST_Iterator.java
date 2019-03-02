/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {

    // Make a ArrayList from BST and utilize its iterator
    ArrayList<Integer> list = new ArrayList();
    Iterator<Integer> it;
    public BSTIterator(TreeNode root) {
        populateList(root);
        it = list.iterator(); // REMEMBER
    }
    
    void populateList(TreeNode root){
        if(root == null) return;
        populateList(root.left);
        list.add(root.val);
        populateList(root.right);
    }
    
    /** @return the next smallest number */
    public int next() {
        return it.next();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */