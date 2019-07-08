public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
     
/*    class Node {
        int label;
        ArrayList<Node> neighbors;
        
        public Node(int label) {
            this.label = label;
            this.neighbors = new ArrayList<Node>();
        }
        
        public void add(Node node) {
            neighbors.add(node);
        }
        
    }*/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        if(numCourses == 0) {
            return false;
        }
        
        if(prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        
        int[] indegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < edges.length; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for(int[] course : prerequisites) {
            int key = course[0];
            int pre = course[1];
            indegree[key]++;
            edges[pre].add(key);
        }
        
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        int count = 0;
        
        while(q.size() != 0) {
            count++;
            int node = q.poll();
            if(edges[node].size() == 0) {
                continue;
            } else {
                for(int i = 0; i < edges[node].size(); i++) {
                    int key = (int)edges[node].get(i);
                    indegree[key]--;
                    if(indegree[key] == 0) {
                        q.offer(key);
                    } 
                }
            }
        }
        
        return count == numCourses;
        // Map<Integer, Integer> inDegree = new HashMap<>();
        
        // for(int[] course : prerequisites) {
        //     int key = course[1];
        //     inDegree.put(key, course[0]);
        //     if(inDegree.containsValue(key)) {
        //         return false;
        //     }
        // }
/*        boolean[] ans = new boolean[n];
        
        for(int[] course : prerequisites) {
            int key = course[1];
            if(!inDegree.containsKey(key)) {
                Node node = new node(key);
            } else {
                Node node = inDegree.get(key);
            }
            
            node.add(course[0]);
            inDegree.put(key, node);
        }
        
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(!inDegree.containsKey(i)) {
                
            } else {
            }
        }*/
        
        // return true;
    }
}