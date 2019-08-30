class Solution {
    public int totalFruit(int[] tree) {
        if(tree == null || tree.length == 0) {
            return 0;
        }
        
        int left = 0;
        int max = 0;
        int cur = 0;
        int type = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tree.length; i++) {
            map.put(tree[i], 0);
        }
        
        for(int i = 0; i < tree.length; i++) {
            
            cur++;
            
            if(map.get(tree[i]) != 0) {
                map.put(tree[i], map.get(tree[i]) + 1);
            } else {
                map.put(tree[i], 1);
                type++;
            }
            
            while(type > 2) {
                map.put(tree[left], map.get(tree[left]) - 1);
                cur--;
                
                if(map.get(tree[left]) == 0) {
                    type--;
                }
                
                left++;
            }
            
            max = Math.max(cur, max);
        }
        
        return max;
    }
}