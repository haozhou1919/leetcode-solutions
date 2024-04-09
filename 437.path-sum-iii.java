/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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
    // number of paths that starting at root, we dfs to find paths that starting at root and
    // sums up to targetSum, we will stop until to the leaf node, along the search as soon as the
    // sum of the path sums up to targetSum, we increment the count
    public int helper(TreeNode root, int targetSum, long curSum){
        int count = 0;
        if(root == null) return 0;
        curSum += root.val;
        if(curSum == targetSum) count++;
        count += helper(root.left, targetSum, curSum);
        count += helper(root.right, targetSum, curSum);
        return count;
    }
    // we recursively call helper to get the number of valid paths starting at a certain node
    public int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        if(root == null) return 0;
        count += helper(root, targetSum, 0);
        count += pathSum(root.left, targetSum)+pathSum(root.right, targetSum);
        return count;
    }
}
// @lc code=end

