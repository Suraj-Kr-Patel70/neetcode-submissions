class Solution {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {

            // Agar digit 9 nahi hai
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            // Agar digit 9 hai
            digits[i] = 0;
        }

        // Agar sabhi digits 9 the
        int[] result = new int[digits.length + 1];
        result[0] = 1;

        return result;
    }
}
