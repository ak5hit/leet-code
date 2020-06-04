import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int candy(int[] ratings) {

        if (ratings.length == 1) return 1;

        int ans = 0;
        int[] candies = new int[ratings.length];
        TreeMap<Integer, ArrayList<Integer>> ratingIdxMap = new TreeMap<>();

        for (int i = 0; i < ratings.length; ++i) {
            if (!ratingIdxMap.containsKey(ratings[i])) {
                ratingIdxMap.put(ratings[i], new ArrayList<>());
            }
            ratingIdxMap.get(ratings[i]).add(i);
        }

        for (Map.Entry<Integer, ArrayList<Integer>> entry : ratingIdxMap.entrySet()) {
            for (int idx : entry.getValue()) {
                if (idx > 0 && idx < ratings.length - 1) {
                    if (ratings[idx] > ratings[idx - 1]) {
                        candies[idx] = candies[idx - 1] + 1;
                    }
                    if (ratings[idx] > ratings[idx + 1] && candies[idx] <= candies[idx + 1]) {
                        candies[idx] = candies[idx + 1] + 1;
                    }
                }

                if (idx == 0 && ratings[idx] > ratings[idx + 1]) {
                    candies[idx] = candies[idx + 1] + 1;
                }

                if (idx == ratings.length - 1 && ratings[idx] > ratings[idx - 1]) {
                    candies[idx] = candies[idx - 1] + 1;
                }
            }
        }

        for (int candy : candies) {
            ans += candy;
        }

        return ans + ratings.length;
    }
}