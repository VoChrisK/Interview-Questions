/**
 * 
 * Leetcode #11 - https://leetcode.com/problems/container-with-most-water/
 */

class Solution {
    public int maxArea(int[] height) {
        int water;
        int max = 0;
        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            water = Math.min(height[i], height[j]) * (j - i);
            if (water > max)
                max = water;
            if (height[i] < height[j])
                i++;
            else
                j--;
        }

        return max;
    }
}