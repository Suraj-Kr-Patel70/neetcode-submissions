class Solution {
    public List<Integer> partitionLabels(String s) {

        List<Integer> result = new ArrayList<>();

        // Store the last occurrence of every character
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {

            // Current character must be included until its last occurrence
            end = Math.max(end, last[s.charAt(i) - 'a']);

            // We have reached the end of this partition
            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}