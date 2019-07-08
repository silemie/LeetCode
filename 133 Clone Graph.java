/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        
        int key = node.label;
        UndirectedGraphNode copy = new UndirectedGraphNode(key);
        
        Map<Integer, UndirectedGraphNode> hash = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        hash.put(key, copy);
        
        while(q.size() != 0) {
            UndirectedGraphNode cur = q.poll();
            UndirectedGraphNode newNode;
            if(hash.containsKey(cur.label)) {
                newNode = hash.get(cur.label);
            } else {
                newNode = new UndirectedGraphNode(cur.label);
            }
            
            if(cur.neighbors.size() != 0) {
                for(UndirectedGraphNode neighbor : cur.neighbors) {
                    UndirectedGraphNode n;
                    if(hash.containsKey(neighbor.label)) {
                        n = hash.get(neighbor.label);
                    } else {
                        q.offer(neighbor);
                        n = new UndirectedGraphNode(neighbor.label);
                    }
                    newNode.neighbors.add(n);
                    hash.put(neighbor.label, n);
                    
                    //System.out.println("Cur:"+cur.label+" Neighbor:"+neighbor.label);
                    // if(!hash.containsKey(neighbor.label)){
                    //     q.offer(neighbor);
                    //}
                } 
            }
            
            hash.put(cur.label, newNode);
        }
        
        return hash.get(key);
    }
}