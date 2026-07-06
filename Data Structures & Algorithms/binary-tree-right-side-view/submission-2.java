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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
            while(q.peek() != null)
            {
                TreeNode temp = q.poll();
                if(q.peek() == null)
                {
                    list.add(temp.val);
                }
                if(temp.left != null)
                q.add(temp.left);
                if(temp.right!= null)
                q.add(temp.right);
            }
            q.poll();
            if(!q.isEmpty())
            q.add(null);

        }
        return list;
    }
}
