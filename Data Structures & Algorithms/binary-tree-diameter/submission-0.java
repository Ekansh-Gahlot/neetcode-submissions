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
    int d = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return d;
    }

    public int calculateHeight(TreeNode root){
        if(root == null) return 0;

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        d = Math.max(d,(leftHeight+rightHeight));

        return Math.max(leftHeight,rightHeight)+1;
    }
}
