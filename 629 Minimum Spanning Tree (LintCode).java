/**
 * Definition for a Connection.
 * public class Connection {
 *   public String city1, city2;
 *   public int cost;
 *   public Connection(String city1, String city2, int cost) {
 *       this.city1 = city1;
 *       this.city2 = city2;
 *       this.cost = cost;
 *   }
 * }
 */
public class Solution {
    /**
     * @param connections given a list of connections include two cities and cost
     * @return a list of connections from results
     */
     
    static Comparator<Connection> comp = new Comparator<Connection>() {
        public int compare(Connection a, Connection b) {
            if(a.cost != b.cost) {
                return a.cost - b.cost;
            }
            
            if(a.city1.equals(b.city1)) {
                return a.city2.compareTo(b.city2);
            }
            
            return a.city1.compareTo(b.city1);
        }
    };
    
    HashMap<String, Integer> map;
    int[] root;
    public List<Connection> lowestCost(List<Connection> connections) {
        // Write your code here
        List<Connection> ans = new ArrayList<>();
        //if(connections.size() == 0) {
        //    return ans;
        //}
        
        map = new HashMap<>();
        Collections.sort(connections, comp);
        
        int index = 0;
        for(Connection c : connections) {
            if(!map.containsKey(c.city1)) {
                map.put(c.city1, index++);
            }
            if(!map.containsKey(c.city2)) {
                map.put(c.city2, index++);
            }
        }
        
        root = new int[index + 1];
        for(int i = 1; i < root.length; i++) {
            root[i] = i;
        }
        
        for(Connection connection : connections) {
            int a = map.get(connection.city1);
            int b = map.get(connection.city2);
            
            int fa = find(a);
            int fb = find(b);
            //System.out.println(fa);
            //System.out.println(fb);
            if(fa != fb) {
                root[fa] = fb;
                ans.add(connection);
            }
        }
        if(ans.size() != index - 1) {
            return new ArrayList<Connection>();
        }
        return ans;
    }
    
    private int find(int x) {
        int fx, j;
        j = x;
        while(j != root[j]) {
            j = root[j];
        }
        
        //path compression
        while(x != j) {
            fx = root[x];
            root[x] = j;
            x = fx;
        }
        
        return j;
    }
}