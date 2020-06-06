import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[][] reconstructQueue(int[][] people) {

        if (people.length == 0) return people;

        int[][] ans = new int[people.length][2];
        for (int i = 0; i < people.length; ++i) {
            ans[i][0] = -1;
            ans[i][1] = -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(people.length, (o1, o2) -> {
            if (o1[0] < o2[0]) return -1;
            else if (o1[0] > o2[0]) return 1;
            else return Integer.compare(o1[1], o2[1]);
        });

        pq.addAll(Arrays.asList(people));

        while (!pq.isEmpty()) {
            int[] smallest = pq.poll();
            int spaces = smallest[1];

            for (int i = 0; i < ans.length; ++i) {
                if (ans[i][0] == -1) {
                    if (spaces == 0) {
                        ans[i] = smallest;
                        break;
                    } else {
                        spaces--;
                    }
                } else if(ans[i][0] >= smallest[0]) {
                    spaces--;
                }
            }
        }

        return ans;
    }
}