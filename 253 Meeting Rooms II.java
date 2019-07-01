class Point {
    int x, flag;
    public Point(int x, int flag) {
        this.x = x;
        this.flag = flag;
    }
    
    public static Comparator<Point> PointComparator = new Comparator<Point>() {
        public int compare(Point a, Point b) {
            if(a.x != b.x) {
                return a.x - b.x;
            } else {
                if(a.flag == 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    };
}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int count = 0;
        int maxCount = 0;
        ArrayList<Point> points = new ArrayList<>();
        
        for(int[] interval : intervals){
            points.add(new Point(interval[0], 0));
            points.add(new Point(interval[1], 1));
        }
        
        Collections.sort(points, Point.PointComparator);
        
        for(Point p : points) {
            if(p.flag == 1) {
                count--;
            } else if(p.flag == 0) {
                count++;
            }
            //System.out.println(count);
            if(count > maxCount) {
                maxCount = count;
            }
        }
        
        return maxCount;
    }
}