class Solution {
    
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int m;
    int n;
    
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }
        
        m = grid.length;
        n = grid[0].length;
        int islands = 0;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    doBFS(grid, i, j);
                    islands++;
                }
            }
        }
        
        return islands;
    }
    
    private void doBFS(char[][] grid, int i, int j) {
        
        Point point = new Point(i, j);
        Queue<Point> q = new LinkedList<>();
        q.offer(point);
        grid[i][j] = '0';
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        while(q.size() != 0) {
            Point p = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = p.x + dx[k];
                int ny = p.y + dy[k];
                if(isValid(nx, ny) && grid[nx][ny] == '1') {
                    q.offer(new Point(nx, ny));
                    grid[nx][ny] = '0';
                }
            }
        }
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}