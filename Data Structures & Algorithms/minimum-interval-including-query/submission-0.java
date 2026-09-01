//import java.util.*;

class Solution {

    public int[] minInterval(int[][] intervals, int[] queries) {

        // Intervals ko left ke according sort karo
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Queries ko sort karo, lekin original index bhi yaad rakho
        int[][] q = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            q[i][0] = queries[i];  // query value
            q[i][1] = i;           // original index
        }

        Arrays.sort(q, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[queries.length];

        // Default answer -1
        Arrays.fill(result, -1);

        // Min heap:
        // [interval length, right]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int i = 0;

        for (int[] query : q) {

            int value = query[0];
            int originalIndex = query[1];

            // Jo intervals query se pehle start ho chuke hain,
            // unhe heap mein daalo
            while (i < intervals.length &&
                   intervals[i][0] <= value) {

                int left = intervals[i][0];
                int right = intervals[i][1];

                int length = right - left + 1;

                pq.offer(new int[]{length, right});

                i++;
            }

            // Jo intervals query ko cover nahi kar sakte,
            // unhe remove karo
            while (!pq.isEmpty() &&
                   pq.peek()[1] < value) {

                pq.poll();
            }

            // Heap ka top = shortest valid interval
            if (!pq.isEmpty()) {
                result[originalIndex] = pq.peek()[0];
            }
        }

        return result;
    }
}