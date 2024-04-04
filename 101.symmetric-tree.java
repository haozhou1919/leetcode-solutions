/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
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
    public boolean isSymmetric(TreeNode root) {
      return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        else if(left != null && right != null){
            if(left.val == right.val) return helper(left.right, right.left)&&helper(left.left, right.right);
            else return false;
        }
        else return false;
    }
}
// @lc code=end

