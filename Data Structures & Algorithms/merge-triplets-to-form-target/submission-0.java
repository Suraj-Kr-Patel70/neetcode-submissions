class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        boolean x = false;
        boolean y = false;
        boolean z = false;

        for (int[] t : triplets) {

            // Ignore triplets that exceed target
            if (t[0] > target[0] ||
                t[1] > target[1] ||
                t[2] > target[2]) {
                continue;
            }

            // This triplet can safely contribute
            if (t[0] == target[0]) {
                x = true;
            }

            if (t[1] == target[1]) {
                y = true;
            }

            if (t[2] == target[2]) {
                z = true;
            }
        }

        return x && y && z;
    }
}
