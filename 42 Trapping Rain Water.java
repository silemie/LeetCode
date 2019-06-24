class Pair {
    int i, val;
    public Pair(int i, int val) {
        this.i = i;
        this.val = val;
    }
}

class PairComparator implements Comparator<Pair>{
    public int compare(Pair a, Pair b) {
        return a.val - b.val;
    }
}

public class Solution {

    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights.length == 0) {
            return 0;
        }
        
        int water = 0;
        boolean[] done = new boolean[heights.length];
        for(int i = 0; i < heights.length; i++) {
            done[i] = false;
        }

        
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(heights.length, new PairComparator());
        heap.offer(new Pair(0, heights[0]));
        heap.offer(new Pair(heights.length - 1, heights[heights.length - 1]));
        done[0] = true;
        done[heights.length - 1] = true;
        int[] steps = {1, -1};
        
        while(!heap.isEmpty()) {
            Pair min = heap.poll();
            for(int i = 0; i < 2; i++) {
                int nId = min.i + steps[i];
                if(nId > 0 && nId < heights.length && !done[nId]) {
                    int waterLine = Math.max(min.val, heights[nId]);
                    water += waterLine - heights[nId];
                    heap.offer(new Pair(nId, waterLine));
                    done[nId] = true;
                }
            }
        }
        
        return water;
        
    }
}
