class Solution {
    
    Map<Integer, Integer> hash = new HashMap<>();
    public int fib(int N) {
        
        hash.put(0, 0);
        hash.put(1, 1);
        
        return fibHelper(N);
    }
    
    private int fibHelper(int N) {
        if(N == 0) {
            return 0;
        }
        
        if(N == 1) {
            return 1;
        }
        
        if(hash.containsKey(N)) {
            return hash.get(N);
        }
        
        int second = fibHelper(N - 2);        
        int first = fibHelper(N - 1);
        
        hash.put(N, second + first);
        
        return second + first;
    }
}