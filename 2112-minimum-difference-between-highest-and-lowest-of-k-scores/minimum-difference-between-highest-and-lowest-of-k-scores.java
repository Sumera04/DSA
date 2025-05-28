class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, min = Integer.MAX_VALUE;
        for (int end = start + k - 1; end < nums.length; end++) {
            min = Math.min(min, nums[end] - nums[start]);
            start++;
        }

        return min;
    }
}