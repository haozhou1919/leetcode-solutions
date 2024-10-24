/*
 * @lc app=leetcode id=700 lang=java
 *
 * [700] Search in a Binary Search Tree
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null) return null;
        if(root.val == val) return root;
        if(root.val < val) return searchBST(root.right, val);
        else return searchBST(root.left, val);
    }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.val == val) return cur;
            if(cur.val < val) cur = cur.right;
            else cur = cur.left;
        }
        return null;
    }
}
// @lc code=end

