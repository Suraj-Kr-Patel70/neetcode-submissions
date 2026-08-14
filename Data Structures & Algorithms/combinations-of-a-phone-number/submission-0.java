class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] mapping = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, "", mapping, result);

        return result;
    }

    private void backtrack(String digits,
                            int index,
                            String current,
                            String[] mapping,
                            List<String> result) {

        // All digits processed
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // Get letters for current digit
        String letters = mapping[digits.charAt(index) - '0'];

        // Try every possible letter
        for (char ch : letters.toCharArray()) {

            // Choose
            backtrack(
                digits,
                index + 1,
                current + ch,
                mapping,
                result
            );

            // Backtracking happens automatically
            // because String is immutable
        }
    }
}