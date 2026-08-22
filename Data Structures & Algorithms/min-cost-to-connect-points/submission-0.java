class Solution {

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        // minDist[i] = minimum cost to connect point i
        // to the points already included in MST
        int[] minDist = new int[n];

        Arrays.fill(minDist, Integer.MAX_VALUE);

        // Start from point 0
        minDist[0] = 0;

        boolean[] visited = new boolean[n];

        int totalCost = 0;

        for (int count = 0; count < n; count++) {

            // Find the unvisited point with minimum distance
            int curr = -1;

            for (int i = 0; i < n; i++) {
                if (!visited[i] &&
                    (curr == -1 || minDist[i] < minDist[curr])) {

                    curr = i;
                }
            }

            // Add this point to MST
            visited[curr] = true;
            totalCost += minDist[curr];

            // Update distances of remaining points
            for (int next = 0; next < n; next++) {

                if (!visited[next]) {

                    int distance =
                        Math.abs(points[curr][0] - points[next][0])
                        + Math.abs(points[curr][1] - points[next][1]);

                    minDist[next] = Math.min(minDist[next], distance);
                }
            }
        }

        return totalCost;
    }
}