class Pair {
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
     * @param heights: a matrix of integers
     * @return: an integer
     */
    
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};
    
    public int trapRainWater(int[][] heights) {
        // write your code here
        if(heights.length == 0 || heights[0].length == 0) {
            return 0;
        }
        
        int m = heights.length;
        int n = heights[0].length;
        int res = 0;
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(m * n, new PairComparator());
        boolean [][] done = new boolean[m][n];
        
        int i, j, d, nx, ny;
        for(i = 0; i < m; i++) {
            for(j = 0; j < n; j++) {
                done[i][j] = false;
                if(i == 0 || i == m - 1 || j == 0|| j == n - 1) {
                    heap.offer(new Pair(i, j, heights[i][j]));
                    done[i][j] = true;
                }
            }
        }
        
        while(!heap.isEmpty()){
            Pair top = heap.poll();
            for(d = 0; d < 4; d++) {
                nx = top.x + dx[d];
                ny = top.y + dy[d];
                
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !done[nx][ny]) {
                    //(nx, ny) is Q
                    //Compare P and Q
                    //P's water line is top.val
                    //Q's height is heights[nx][ny]
                    int nh = Math.max(heights[nx][ny], top.val);
                    //nh is Q's water heights
                    res += nh - heights[nx][ny];
                    heap.offer(new Pair(nx, ny, nh));
                    done[nx][ny] = true;
                    
                }
            }
        }
        
        return res;
    }
}