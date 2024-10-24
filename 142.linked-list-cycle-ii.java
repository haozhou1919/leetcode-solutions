/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// my initial solution
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode cur = head;
        while(cur!= null){
            map.put(cur, map.getOrDefault(cur, 0)+1);
            if(map.get(cur)>1) return cur;
            cur = cur.next;
        }
        return null;
    }
}
// editorial better approach using HashSet
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // Initialize an empty hash set
        HashSet<ListNode> nodesSeen = new HashSet<>();
        
        // Start from the head of the linked list
        ListNode node = head;
        while (node != null) {
            // If the current node is in nodesSeen, we have a cycle
            if (nodesSeen.contains(node)) {
                return node;
            } else {
                // Add this node to nodesSeen and move to the next node
                nodesSeen.add(node);
                node = node.next;
            }
        }

        // If we reach a null node, there is no cycle
        return null;
    }
}

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        // for empty list return null
        // for one element list without self cycling, return null
        while(fast!=null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                ListNode i1, i2;
                i1 = head;
                i2 = slow;
                while(i1 != i2){
                    i1 = i1.next;
                    i2 = i2.next;
                }
                return i1;
            }
        }
        return null;

    }
}
// @lc code=end

