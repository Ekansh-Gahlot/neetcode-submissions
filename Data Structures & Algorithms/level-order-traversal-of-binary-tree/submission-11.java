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
        q.add(root);
        q.add(null);

        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
         

        while(!q.isEmpty())
        {
            List<Integer> tempList = new ArrayList<>();
            while(q.peek()!=null)
            {
                TreeNode temp = q.poll();
                tempList.add(temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            q.poll();
            list.add(tempList);
            if(!q.isEmpty())
            q.add(null);
            
        }
        return list;
    }
}
