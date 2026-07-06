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
    public boolean isBalanced(TreeNode root) {
        int lh;
        int rh;
        if(root == null) return true;

        lh = height(root.left);
        rh = height(root.right);

        if(Math.abs(lh-rh) <=1 && isBalanced(root.right) && isBalanced(root.left))
        return true;
        return false;
    }

    public int height(TreeNode root)
    {
        if(root == null) return 0;

        return (Math.max(height(root.right),height(root.left))+1);
    }
}
