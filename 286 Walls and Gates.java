class Solution {
    public void wallsAndGates(int[][] rooms) {
        
        if(rooms.length == 0 || rooms[0].length == 0) {
            return ;
        }
        
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    doBFS(rooms, i, j);
                }
            }
        }
    }
    
    class Point {
        int x;
        int y;
        int path;
        
        public Point(int x, int y, int p) {
            this.x = x;
            this.y = y;
            this.path = p;
        }
    }
    
    private void doBFS(int[][] rooms, int x, int y) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        int m = rooms.length;
        int n = rooms[0].length;
        
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 0));
        
        while(q.size() != 0) {
            Point p = q.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && rooms[nx][ny] != -1) {
                    if(rooms[nx][ny] > p.path + 1) {
                        //System.out.println("x:" + nx + " y:" + ny + " Steps:" + steps);
                        rooms[nx][ny] = p.path + 1;
                        q.offer(new Point(nx, ny, p.path + 1));
                    }
                } 
            }
        }
    }
}