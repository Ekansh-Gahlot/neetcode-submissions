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
    public boolean isValidBST(TreeNode root) {
        boolean result = isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return result;
    }

    public boolean isValid(TreeNode root, int minValue, int maxValue){
        if(root == null) return true;
        if(root.val <= minValue || root.val >= maxValue)
        return false;
        return isValid(root.left, minValue ,root.val) && isValid(root.right, root.val, maxValue);
    }
}
