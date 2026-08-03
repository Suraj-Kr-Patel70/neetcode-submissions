//import java.util.PriorityQueue;
//import java.util.Collections;

class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        // Smash until one or no stone remains
        while (maxHeap.size() > 1) {

            int y = maxHeap.poll(); // largest
            int x = maxHeap.poll(); // second largest

            if (y != x) {
                maxHeap.offer(y - x);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}