public class ConnectingGraph2 {
    
    int[] father;
    int[] size;
    
    /*
    * @param n: An integer
    */public ConnectingGraph2(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        size = new int[n + 1];
        
        for(int i = 1; i < n + 1; i++) {
            father[i] = i;
            size[i] = 1;
        }
    }
    
    private int find(int x) {
        int j, fx;
        j = x;
        while(father[j] != j) {
            j = father[j];
        }
        
        while(j != x) {
            fx = father[x];
            father[x] = j;
            x = fx;
        }
        
        return j;
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int fa = find(a);
        int fb = find(b);
        
        if(fa != fb){
            father[fa] = fb;
            size[fb] += size[fa];
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int query(int a) {
        // write your code here
        int root = find(a);
        return size[root];
    }
}