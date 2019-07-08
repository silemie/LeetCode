/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        if(graph.size() == 0) {
            return ans;
        }
        Map<Integer, Integer> inDegree = new HashMap<>();
        //<Key, Value>
        Queue<DirectedGraphNode> q = new LinkedList<>();
        
        for(DirectedGraphNode node : graph) {
            if(node.neighbors.size() != 0) {
                for(DirectedGraphNode neighbor : node.neighbors) {
                    int key = neighbor.label;
                    if(inDegree.containsKey(key)) {
                        int val = inDegree.get(key) + 1;
                        inDegree.put(key, val);
                    } else {
                        inDegree.put(key, 1);
                    }
                }
            }
        }
        
        for(DirectedGraphNode node : graph) {
            if(!inDegree.containsKey(node.label)) {
                q.offer(node);
            }
        }
        
        while(q.size() != 0) {
            DirectedGraphNode cur = q.poll();
            ans.add(cur);
            
            if(cur.neighbors.size() != 0) {
                for(DirectedGraphNode neighbor : cur.neighbors) {
                    int in = inDegree.get(neighbor.label) - 1;
                    inDegree.put(neighbor.label, in);
                    if(in == 0) {
                        q.offer(neighbor);
                    }
                }
            }
        }
        
        return ans;
        
    }
}