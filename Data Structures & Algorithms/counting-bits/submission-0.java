class Solution {
    public int[] countBits(int n) {
        // Initialize an array of size n + 1
        int[] output = new int[n + 1];
        
        // Populate the array using the optimal DP relation
        for (int i = 1; i <= n; i++) {
            // output[i >> 1] shifts 'i' right by 1 bit (same as i / 2)
            // (i & 1) checks if the least significant bit is 1 (if 'i' is odd)
            output[i] = output[i >> 1] + (i & 1);
        }
        
        return output;
    }
}

