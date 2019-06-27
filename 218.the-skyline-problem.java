import java.util.ArrayList;

/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 *
 * https://leetcode.com/problems/the-skyline-problem/description/
 *
 * algorithms
 * Hard (31.81%)
 * Likes:    1218
 * Dislikes: 64
 * Total Accepted:    94.7K
 * Total Submissions: 297.7K
 * Testcase Example:  '[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]'
 *
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Now suppose you are
 * given the locations and height of all the buildings as shown on a cityscape
 * photo (Figure A), write a program to output the skyline formed by these
 * buildings collectively (Figure B).
 * ⁠   
 * 
 * The geometric information of each building is represented by a triplet of
 * integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and
 * right edge of the ith building, respectively, and Hi is its height. It is
 * guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You
 * may assume all buildings are perfect rectangles grounded on an absolutely
 * flat surface at height 0.
 * 
 * For instance, the dimensions of all buildings in Figure A are recorded as: [
 * [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * 
 * The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key
 * point is the left endpoint of a horizontal line segment. Note that the last
 * key point, where the rightmost building ends, is merely used to mark the
 * termination of the skyline, and always has zero height. Also, the ground in
 * between any two adjacent buildings should be considered part of the skyline
 * contour.
 * 
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3
 * 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * 
 * Notes:
 * 
 * 
 * The number of buildings in any input list is guaranteed to be in the range
 * [0, 10000].
 * The input list is already sorted in ascending order by the left x position
 * Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output
 * skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not
 * acceptable; the three lines of height 5 should be merged into one in the
 * final output as such: [...[2 3], [4 5], [12 7], ...]
 * 
 * 
 */
class Point {
    int x, h, left;
    
    public Point(int x, int h, int left) {
        this.x = x;
        this.h= h;
        this.left = left; //isLeft = 1; isRight = 0;
    }

    public static Comparator<Point> PointComparator = new Comparator<Point>() {
        public int compare(Point a, Point b) {
            return a.x - b.x;
        }
    };
}

/*class PointComparator implements Comparator<Point> {
    public int compare(Point a, Point b) {
        return b.h - a.h;
    }
}*/

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<>();
        if(buildings.length == 0) {
            return ans;
        }

        List<Point> points = new ArrayList<>();

        for(int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];
            points.add(new Point(building[0], building[2], 1));
            points.add(new Point(building[1], building[2], 0));
        }

        Collections.sort(points, Point.PointComparator);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(buildings.length * 2, Collections.reverseOrder());
        maxHeap.offer(0);
        int prev = 0;
        int prevx = 0;

        for(Point p : points) {

            ArrayList<Integer> record = new ArrayList<>();
            if(p.left == 1) {
                if(p.h > maxHeap.peek() && p.h != prev) {

                    record.add(p.x);
                    record.add(p.h);
                    ans.add(record);
                }
                if(p.h == prev) {
                    ans.remove(ans.size() -1 );
                }
                maxHeap.offer(p.h);
            } else {
                prev = maxHeap.peek();
                prevx = p.x;
                maxHeap.remove(p.h);
                if(p.h > maxHeap.peek()) {
                    record.add(p.x);
                    record.add(maxHeap.peek());
                    ans.add(record);
                }
            }
        }

        return ans;
    }
}

