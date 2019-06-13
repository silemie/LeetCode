class Point {
    int a;
    int b;
    int val;
    
    public Point(int a, int b, int val) {
        this.a = a;
        this.b = b;
        this.val = val;
    }
}

class PointComparator implements Comparator<Point> {
    public int compare(Point a, Point b) {
        return a.val - b.val;
    }
}

public class Solution {
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        int a = A.length;
        int b = B.length;
        boolean[][] matrix = new boolean[a][b];
        matrix[0][0] = true;
        
        PriorityQueue<Point> pq = new PriorityQueue<>(k, new  PointComparator());
        pq.add(new Point(0, 0, A[0]+B[0]));
        
        for(int i = 0; i < k - 1; i++) {
            Point cur = pq.poll();
            int x = cur.a + 1;
            int y = cur.b + 1;
            if(x < a && !matrix[x][cur.b]) {
                matrix[x][cur.b] = true;
                pq.add(new Point(x, cur.b, A[x] + B[cur.b]));
            }
            if(y < b && !matrix[cur.a][y]) {
                matrix[cur.a][y] = true;
                pq.add(new Point(cur.a, y, A[cur.a] + B[y]));
            }
            
        }
        
        return pq.peek().val;
    }
}