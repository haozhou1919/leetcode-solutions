/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }
}

// look at the above recursion, we found that we not only put the TreeNode on the 
// stack but we also put the depth on the stack
class Solution {
    public int maxDepth(TreeNode root) {
      LinkedList<TreeNode> stack = new LinkedList<>();
      LinkedList<Integer> depths = new LinkedList<>();
      if (root == null) return 0;
  
      stack.add(root);
      depths.add(1);
  
      int depth = 0, current_depth = 0;
      while(!stack.isEmpty()) {
        root = stack.pollLast();
        current_depth = depths.pollLast();
        if (root != null) {
          depth = Math.max(depth, current_depth);
          stack.add(root.left);
          stack.add(root.right);
          depths.add(current_depth + 1);
          depths.add(current_depth + 1);
        }
      }
      return depth;
    }
  };
// @lc code=end

