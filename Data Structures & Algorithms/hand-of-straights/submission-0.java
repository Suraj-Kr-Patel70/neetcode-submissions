class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        // Total cards must be divisible by groupSize
        if (hand.length % groupSize != 0) {
            return false;
        }

        // Store card value -> frequency
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int card : hand) {
            map.put(card, map.getOrDefault(card, 0) + 1);
        }

        // Keep making groups
        while (!map.isEmpty()) {

            // Smallest available card
            int first = map.firstKey();

            // Need first, first+1, first+2 ... 
            for (int i = 0; i < groupSize; i++) {

                int card = first + i;

                // Required card doesn't exist
                if (!map.containsKey(card)) {
                    return false;
                }

                // Use one card
                map.put(card, map.get(card) - 1);

                // Remove when frequency becomes 0
                if (map.get(card) == 0) {
                    map.remove(card);
                }
            }
        }

        return true;
    }
}