/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    
    private int convertToInt(int x, int y, int m) {
        return x * m + y;
    }
    
    class UnionFind {
        
        Map<Integer, Integer> father;
        public UnionFind(int n, int m) {
            father = new HashMap<>();
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    int id = convertToInt(i, j ,m);
                    father.put(id, id);
                }
            } 
        }
        
        public int find(int x) {
            int j, fx;
            j = x;
            while(j != father.get(j)) {
                j = father.get(j);
            }
            
            while(x != j) {
                fx = father.get(x);
                father.put(x, j);
                x = fx;
            }
            return j;
        }
        
        public void union(int x, int y) {
            int fx = find(x);
            int fy = find(y);
            
            if(fx != fy) {
                father.put(fx, fy);
            }
        }
    }
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    int [] dx = {-1, 0, 1, 0};
    int [] dy = {0, -1, 0, 1};
    
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> ans = new ArrayList<>();
        if(operators == null) {
            return ans;
        }
        
        UnionFind uf = new UnionFind(n, m);
        int[][] isIsland = new int[n][m];
        ans.add(0);
        
        for(int i = 0; i < operators.length; i++) {
            Point op = operators[i];
            int x = op.x;
            int y = op.y;
            int count = ans.get(i);
            
            if(isIsland[x][y] == 0) {
                count++;
                isIsland[x][y] = 1;
                int id = convertToInt(x, y, m);
                //System.out.println(count);                
                for(int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    int nid = convertToInt(nx, ny, m);
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m && isIsland[nx][ny] == 1) {
                        int fx = uf.find(id);
                        int fnx = uf.find(nid);
                        //System.out.println(id);
                        //System.out.println(nid);
                        if(fx != fnx) {
                            count--;
                        }
                        uf.union(id, nid);
                    }
                }
            }
            ans.add(count);
        }
        ans.remove(0);
        return ans;
    }
}