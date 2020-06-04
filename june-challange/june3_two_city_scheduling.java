import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(o -> Math.abs(o[0] - o[1])));

        int n = costs.length / 2;
        int city1 = 0, city2 = 0, ans = 0;

        for (int[] cost: costs) {
            if (city1 == n) {
                ans += cost[1];
                city2++;
            } else if (city2 == n) {
                ans += cost[0];
                city1++;
            } else if (cost[0] < cost[1]) {
                ans += cost[0];
                city1++;
            } else {
                ans += cost[1];
                city2++;
            }
        }

        return ans;
    }
}