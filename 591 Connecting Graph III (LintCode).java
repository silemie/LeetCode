public class ConnectingGraph3 {
    int [] father;
    int size;
    
    public ConnectingGraph3(int a) {
        father = new int[a + 1];
        size = a;
        
        for(int i = 1; i < a + 1; i++) {
            father[i] = i;
        }
    }
    
    private int find(int a) {
        int j, fa;
        j = a;
        while(j != father[j]) {
            j = father[j];
        }
        
        while(j != a) {
            fa = father[a];
            father[a] = j;
            a = fa;
        }
        
        return j;
        
    }
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: nothing
     */
    public void connect(int a, int b) {
        // write your code here
        int fa = find(a);
        int fb = find(b);
        
        if(fa != fb) {
            father[fa] = fb;
            size--;
        }
    }

    /**
     * @return: An integer
     */
    public int query() {
        // write your code here
        return size;
    }
}