class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        if(houses.length == 0 || heaters.length == 0) {
            return 0;
        }
        
        Arrays.sort(heaters);
        
        int dist = Integer.MIN_VALUE;
        for(int house : houses) {
            int index = doBS(heaters, house);
            
            int distLeft = Integer.MAX_VALUE;
            int distRight = Integer.MAX_VALUE;
            
            if(index == -1) {
                dist = Math.max(dist, Math.abs(house - heaters[0]));
            } else if(index == heaters.length || index == heaters.length - 1) {
                dist = Math.max(dist, Math.abs(house - heaters[heaters.length - 1]));
            } else {
                distLeft = Math.abs(house - heaters[index]);
                distRight = Math.abs(house - heaters[index + 1]);
                dist = Math.max(dist, Math.min(distLeft, distRight));
            } 
            
            //System.out.println("House:" + house + " dist:" + dist);
        }
        
        return dist;
    }
    
    //return the last postion of heater that is smaller than house position
    //In other word, return the left heater
    private int doBS(int[] heaters, int house) {
        
        if(house < heaters[0]) {
            return -1;
        }
        
        if(house > heaters[heaters.length - 1]) {
            return heaters.length;
        }
        
        int left = 0;
        int right = heaters.length - 1;
        
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            
            if(heaters[mid] == house) {
                return mid;
            }
            
            if(heaters[mid] > house) {
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if(house >= heaters[left]) {
            return left;
        } else {
            return right;
        }
    }
}