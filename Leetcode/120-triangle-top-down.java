/**
 * 
 * Leetcode #120 - https://leetcode.com/problems/triangle/
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;

        List<Integer> sumsSoFar = new ArrayList<Integer>();
        sumsSoFar.add(triangle.get(0).get(0));
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 1; i < triangle.size(); i++) {
            sum1 = sumsSoFar.get(sumsSoFar.size() - 1) + triangle.get(i).get(triangle.get(i).size() - 1);
            sumsSoFar.add(sum1);

            for (int j = triangle.get(i).size() - 2; j >= 1; j--) {
                sum1 = triangle.get(i).get(j) + sumsSoFar.get(j - 1);
                sum2 = triangle.get(i).get(j) + sumsSoFar.get(j);
                sumsSoFar.set(j, Math.min(sum1, sum2));
            }

            sum1 = sumsSoFar.get(0) + triangle.get(i).get(0);
            sumsSoFar.set(0, sum1);
        }

        int min = sumsSoFar.get(0);

        for (int i = 1; i < sumsSoFar.size(); i++) {
            if (sumsSoFar.get(i) < min)
                min = sumsSoFar.get(i);
        }

        return min;
    }
}