class Solution {
    
//     int m;
//     int n;
//     boolean[][] done;
    
    class Point {
        int x;
        int y;
        
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public void solve(char[][] board) {
        
        if(board.length == 0 || board[0].length == 0) {
            return ;
        }
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            doBFS(board, i, 0);
            doBFS(board, i, n - 1);
        }
        
        for(int j = 0; j < n; j++) {
            doBFS(board, 0, j);
            doBFS(board, m - 1 , j);
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'W') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void doBFS(char[][] board, int x, int y) {
        
        if(board[x][y] != 'O') {
            return ;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        board[x][y] = 'W';
        
        while(q.size() != 0) {
            Point p = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(isValid(board, nx, ny) && board[nx][ny] == 'O') {
                    board[nx][ny] = 'W';
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }
    
    private boolean isValid(char[][] board, int x, int y) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}
        