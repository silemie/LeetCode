public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        if(numCourses == 0) {
            return new int[0];
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        
        int[] indegree = new int[numCourses];
        List[] edges = new ArrayList[numCourses];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<Integer>();
        }
        
        for(int[] courses : prerequisites) {
            int key = courses[0];
            int pre = courses[1];
            indegree[key]++;
            edges[pre].add(key);
        }
        
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        
        while(q.size() != 0) {
            int course = q.poll();
            ans.add(course);
            //System.out.println(ans.get(ans.size() - 1));
            
            if(edges[course].size() != 0) {
                for(int i = 0; i < edges[course].size(); i++) {
                    int key = (int) edges[course].get(i);
                    indegree[key]--;
                    if(indegree[key] == 0) {
                        q.offer(key);
                    }
                }
            }
        }
        
        if(ans.size() != numCourses) {
            return new int[0];
        } else {
            int[] sort = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                sort[i] = ans.get(i);
            }
            return sort;
        }
        
    }
}