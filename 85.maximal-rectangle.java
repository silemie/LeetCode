/*
 * @lc app=leetcode id=85 lang=java
 *
 * [85] Maximal Rectangle
 *
 * https://leetcode.com/problems/maximal-rectangle/description/
 *
 * algorithms
 * Hard (33.59%)
 * Likes:    1475
 * Dislikes: 52
 * Total Accepted:    124.3K
 * Total Submissions: 369.9K
 * Testcase Example:  '[["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]'
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
 * containing only 1's and return its area.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * ⁠ ["1","0","1","0","0"],
 * ⁠ ["1","0","1","1","1"],
 * ⁠ ["1","1","1","1","1"],
 * ⁠ ["1","0","0","1","0"]
 * ]
 * Output: 6
 * 
 * 
 */
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = n == 0 ? 0 : matrix[0].length;

        int[][] height = new int[n][m + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '0') {
                    height[i][j] = 0;
                } else {
                    if(i == 0) {
                        height[i][j] = 1;
                    } else {
                        height[i][j] = height[i -1][j] + 1;
                    }
                }
            }
        }

        int maxArea = 0;
        for(int j = 0; j < height.length; j++) {
            int area = maxHist(height[j]);
            if(area > maxArea) {
                maxArea = area;
            }
        }

        return maxArea;
    }

    private int maxHist(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int i = 0;

        while(i < height.length) {
            if(stack.isEmpty() || height[stack.peek()] <= height[i]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                int width = 0;
                if(stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                area = Math.max(area, width * height[top]);
                
            }
        }
        return area;
    }
}

