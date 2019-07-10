// class Solution {
//     public int[][] kClosest(int[][] points, int K) {
        
//         if(K == 0 || points.length == 0 || points[0].length == 0) {
//             return new int[0][0];
//         }
        
//         int[][] ans = new int[K][2];
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>();
//         HashMap<Integer, Integer> hash = new HashMap<>();
        
//         int index = 0;
//         for(int[] point : points) {
//             int distance = point[0] * point[0] + point[1]*point[1];
//             pq.offer(distance);
//             hash.put(distance, index);
//             index++;
//         }
        
//         int n = 0;
//         while(n < K) {
//             int dis = pq.poll();
//             ans[n] = points[hash.get(dis)];
//             n++;
//         }
        
//         return ans;
//     }
// }

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        if(K == 0 || points.length == 0 || points[0].length == 0) {
            return new int[0][0];
        }
        
        int[][] ans = new int[K][2];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        //HashMap<Integer, Integer> hash = new HashMap<>();
        //int index = 0;
        for(int[] point : points) {
            pq.offer(point);
            if(pq.size() > K) {
                pq.poll();
            }
            //hash.put(distance, index);
            //index++;
        }
        
        int n = K - 1;
        while(n >= 0) {
            ans[n] = pq.poll();
            n--;
        }
        
        return ans;
    }
}