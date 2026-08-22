//import java.util.*;

class Solution {

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        int INF = Integer.MAX_VALUE;

        int[] price = new int[n];
        Arrays.fill(price, INF);

        price[src] = 0;

        // At most k stops means at most k + 1 flights
        for (int i = 0; i <= k; i++) {

            int[] temp = price.clone();

            for (int[] flight : flights) {

                int from = flight[0];
                int to = flight[1];
                int cost = flight[2];

                // If 'from' is reachable
                if (price[from] != INF) {

                    temp[to] = Math.min(
                        temp[to],
                        price[from] + cost
                    );
                }
            }

            price = temp;
        }

        return price[dst] == INF ? -1 : price[dst];
    }
}
