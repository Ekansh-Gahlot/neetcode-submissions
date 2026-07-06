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
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
        return res;
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            while(q.peek()!=null){
                TreeNode node = q.poll();
                if(node.left!=null)
                q.add(node.left);
                if(node.right!=null)
                q.add(node.right);
                list.add(node.val);
            }
            res.add(new ArrayList<>(list));
            q.poll();
            if(!q.isEmpty())
            q.add(null);
        }
        return res;
    }
}
