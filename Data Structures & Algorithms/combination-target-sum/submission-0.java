class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, target, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(
        int index,
        int target,
        int[] nums,
        List<Integer> current,
        List<List<Integer>> result
    ) {

        // Target reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Target exceeded
        if (target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Reuse same number
            backtrack(
                i,
                target - nums[i],
                nums,
                current,
                result
            );

            // Undo choice
            current.remove(current.size() - 1);
        }
    }
}
