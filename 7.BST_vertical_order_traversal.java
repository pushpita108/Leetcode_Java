import java.util.ArrayList;
import java.util.HashMap;
import java.lang.Integer;
import java.util.List;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
class Solution {

    public void dfs(TreeNode root, HashMap<Integer, ArrayList<Integer>> cols, int level, int min, int max){
        if(root == null) return;
        dfs(root.left, cols, level-1, min, max);
        if( !cols.containsKey(level)){
            ArrayList rootList = new ArrayList<Integer>();
            cols.put(level, rootList);
        }
        cols.get(level).add(root.val);
        min = Math.min(level, min);
        max = Math.max(level, max);
        dfs(root.right, cols, level+1, min, max);
    }
    public List<List<Integer>> verticalOrderDFS(TreeNode root) {
        // column number -> list of nodes in the column 
        HashMap<Integer, ArrayList<Integer>> cols = new HashMap<Integer, ArrayList<Integer>>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MAX_VALUE;

        //Add root to the map
        ArrayList rootList = new ArrayList<Integer>();
        rootList.add(root.val);
        cols.put(0, rootList);

        //DFS from root 
        dfs(root, cols, 0, min, max);
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=min; i<= max; i++ ){
            result.add(cols.get(i));
        }
        return result;
    }

    //////////////////////////////////////////////////////////////////

    public List<List<Integer>> verticalOrderBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
       //map's key is column, we assume the root column is zero, the left node will minus 1 ,and the right node will plus 1
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();

       //to keep track of min and max
        HashMap<TreeNode, Integer> weight = new HashMap<TreeNode, Integer>();

        //start BFS with root 
        queue.offer(root);
        weight.put(root, 0);
        int min = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int w = weight.get(node);
            if (!map.containsKey(w)) {
                map.put(w, new ArrayList<>());
            }
            map.get(w).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                weight.put(node.left, w - 1);
            } 
            if (node.right != null) {
                queue.add(node.right);
                weight.put(node.right, w + 1);
            }
            //update min ,min means the minimum column value, which is the left most node
            min = Math.min(min, w);
        }
        while (map.containsKey(min)) {
            res.add(map.get(min++));
        }
        return res;
    }

}