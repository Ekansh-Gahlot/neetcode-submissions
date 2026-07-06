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
    int preIndex = 0;
    int inIndex = 0;
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return dfs(preOrder, inOrder, Integer.MAX_VALUE);
    }

    public TreeNode dfs(int[] preOrder, int[] inOrder, int limit){

        if(preIndex >= preOrder.length) return null;
        if(inOrder[inIndex] == limit)
        {
            inIndex++;
            return null;
        }
        TreeNode root = new TreeNode(preOrder[preIndex++]);
        root.left = dfs(preOrder, inOrder, root.val);
        root.right = dfs(preOrder, inOrder, limit);
        return root;
    }
}
