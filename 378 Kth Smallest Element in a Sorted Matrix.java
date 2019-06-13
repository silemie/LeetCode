class Pair{
    public int x, y, val;
    public Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.val - b.val;
    }
}

public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] used = new boolean[n][m];
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new PairComparator());
        pq.add(new Pair(0, 0, matrix[0][0]));
        used[0][0] = true;
        
        for(int i = 0; i < k - 1; i++) {
            Pair cur = pq.poll();
            for(int j = 0; j < 2; j++) {
                int nextX = cur.x + dx[j];
                int nextY = cur.y + dy[j];
                if(nextX < n && nextY < m && !used[nextX][nextY]){
                    Pair nextPair = new Pair(nextX, nextY, matrix[nextX][nextY]);
                    used[nextX][nextY] = true;
                    pq.add(nextPair);
                }
            }
        }
        
        return pq.peek().val;
        
        
    }
}