/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lt = new ArrayList<>();
              if(root == null) return lt;
       
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> l = new ArrayList<>();
            for(int i = 0; i < levelSize; i++)
            {
                    TreeNode curr = q.poll();
                    l.add(curr.val);
                    if(curr.left!=null)
                    {
                        q.add(curr.left);
                    }
                    if(curr.right!=null){
                        q.add(curr.right);
                    }
            }
            lt.add(l);
       
        }
        return lt;
    }
}
