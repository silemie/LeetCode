/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        int key = node.val;
        Node copy = new Node(key, new ArrayList<Node>());
        
        Map<Integer, Node> hash = new HashMap<>();
        hash.put(key, copy);
        
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        
        while(q.size() != 0) {
            Node curNode = q.poll();
            Node newNode;
            if(hash.containsKey(curNode.val)) {
                newNode = hash.get(curNode.val);
                //System.out.println("New Node val: " + newNode.val);
            } else {
                newNode = new Node(curNode.val, new ArrayList<Node>());
            }
            
            if(curNode.neighbors.size() != 0) {
                for(Node neighbor : curNode.neighbors) {
                    Node n;
                    if(hash.containsKey(neighbor.val)) {
                        n = hash.get(neighbor.val);
                    } else {
                        q.offer(neighbor);
                        n = new Node(neighbor.val, new ArrayList<Node>());
                    }
                    
                    newNode.neighbors.add(n);
                    hash.put(neighbor.val, n);
                }
            }
            
            hash.put(curNode.val, newNode);
        }
        
        //System.out.println(hash.get(key).val);
        return hash.get(key);
    }
}