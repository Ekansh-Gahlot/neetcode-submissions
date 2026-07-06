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
        q.add(null);
        List<Integer> l = new ArrayList<>();

        while(!q.isEmpty()){

                    TreeNode curr = q.poll();
                    if(curr==null){
                        lt.add(l);
                        if(q.isEmpty())break;
                        else{
                            l = new ArrayList<>();
                            q.add(null);
                            
                        }
                    }else{
                        l.add(curr.val);
                        if(curr.left!=null)
                        {
                            q.add(curr.left);
                        }
                        if(curr.right!=null){
                            q.add(curr.right);
                        }
                    }
        }
        return lt;
    }
}
