class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        
        if(org.length == 0 || seqs.size() == 0) {
            return false;
        }
        
        Map<Integer, HashSet<Integer>> map =  new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        for(int num : org) {
            map.put(num, new HashSet<Integer>());
            indegree.put(num, 0);
        }
        
        int count = 0;
        for(List<Integer> seq : seqs) {
            count += seq.size();
            if (seq.size() >= 1 && (seq.get(0) <= 0 || seq.get(0) > org.length)) {
                return false;
            }
            for(int i = 0; i < seq.size() - 1; i++) {
                int from = seq.get(i);
                int to = seq.get(i + 1);
                if(!indegree.containsKey(to) || !indegree.containsKey(from)) {
                    return false;
                }
                HashSet<Integer> set = map.get(from);
                if(set.add(to)) {
                    indegree.put(to, indegree.get(to) + 1);
                }
                map.put(from, set);
            }
        } 
        
        if(count < org.length) {
            return false;
        }
        
        Queue<Integer> q = new LinkedList<>();
        //List<Integer> sort = new ArrayList<>();
        
        for(int num : org) {
            if(indegree.get(num) == 0) {
                q.offer(num);
            }
        }
        
        int index = 0;
        while(q.size() == 1) {
            int curNode = q.poll();
            
            if(org[index] != curNode) {
                return false;
            }
            
            index++;
            HashSet<Integer> neighbors = map.get(curNode);
            for(int n : neighbors) {
                int in = indegree.get(n) - 1;
                if(in == 0) {
                    q.offer(n);
                }
                indegree.put(n, in);
            }
        }
        
        return index == org.length;
    }
}