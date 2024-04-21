/*
 * @lc app=leetcode id=1971 lang=java
 *
 * [1971] Find if Path Exists in Graph
 */

// @lc code=start
class Solution {
    
    public boolean helper(int n, HashSet<Integer>[] adj, int src, int dest, int[] visited){
        boolean dc = false;
        boolean c = false;
        for(int i = 0; i < n; i++){
            if (adj[src].contains(i)){
                c = true;
            }
            if(adj[src].contains(dest)) {
                dc = true;
                break;
            }
        }
        if(dc) return true;
        if(c){
            boolean connected = false;
            for(int i = 0; i < n; i++){
                if(visited[i]==0 && adj[src].contains(i)){
                    // adj[i][src] = 0;
                    visited[src] = 1;
                    connected = connected || helper(n, adj, i, dest, visited);
                    if(connected) break;
                }
            }
            return connected;
        }
        else return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        HashSet<Integer>[] adj = new HashSet[n];
        int[] visited = new int[n];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new HashSet<Integer>();
        }
        for(int i = 0; i < edges.length; i++){
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        visited[source] =1;
        return helper(n, adj, source, destination, visited);
    }
}
// @lc code=end

