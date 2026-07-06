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
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res;
    }

    public int dfs(TreeNode root, int maxValue){
        if(root == null) return 0;

        if(root.val >= maxValue)
        res = 1;
        else res = 0;
        maxValue = Math.max(maxValue, root.val);

        res+= dfs(root.left, maxValue);
        res+= dfs(root.right, maxValue);
        return res;
    }
}
