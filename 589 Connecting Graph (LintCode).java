public class ConnectingGraph {
    int[] father;
    /*
    * @param n: An integer
    */public ConnectingGraph(int n) {
        // do intialization if necessary
        father = new int[n + 1];
        
        for(int i = 1; i < n + 1; i++) {
            father[i] = i;
        }
    } 
    
    private int find(int a) {
        int j, fa;
        
        j = a;
        while(j != father[j]) {
            j = father[j];
        }
        
        //path compression
        while(j != a) {
            fa = father[a];
            father[a] = j;
            a = fa;
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
        
        if(fa != fb) {
            father[fa] = fb;
        }
    }

    /*
     * @param a: An integer
     * @param b: An integer
     * @return: A boolean
     */
    public boolean query(int a, int b) {
        // write your code here
        int fa = find(a);
        int fb = find(b);
        
        if(fa != fb) {return false;} else {return true;}
    }
}