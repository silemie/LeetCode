public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
     
    int [] tree;
    int size;
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if(edges.length != n - 1) {
            return false;
        }
        
        tree = new int [n + 1];
        size = n;
        
        for(int i = 1; i < n + 1; i++) {
            tree[i] = i;
        }
        
        for(int[] edge : edges) {
            connect(edge[0], edge[1]);
        }
        
        return size == 1;
        
    }
    
    private int find(int a) {
        int r, fa;
        r = a;
        while(r != tree[r]) { 
            r = tree[r];
        }
        
        while(r != a) {
            fa = tree[a];
            tree[a] = r;
            a = fa;
        }
        
        return r;
    }
    
    private void connect(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        
        if(fa != fb) {
            tree[fa] = fb;
            size--;
        }
    }
}