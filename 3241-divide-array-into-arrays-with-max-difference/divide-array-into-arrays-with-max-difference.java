class Solution {
    public int[][] divideArray(int[] nums, int k) {
        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Use a list of lists to store valid groups
        List<List<Integer>> list = new ArrayList<>();

        // Step 3: Traverse the sorted array in chunks of 3
        for (int i = 2; i < nums.length;) {
            int a = nums[i - 2];
            int b = nums[i - 1];
            int c = nums[i];

            // Check the max absolute difference in the group of 3
            if (c - b <= k && c - a <= k && b - a <= k) {
                list.add(Arrays.asList(a, b, c));
                i += 3;
            } else {
                return new int[0][0]; // return empty 2D array if group invalid
            }
        }

        // Step 4: Convert List<List<Integer>> to int[][]
        int[][] result = new int[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            List<Integer> l = list.get(i);
            for (int j = 0; j < 3; j++) {
                result[i][j] = l.get(j);
            }
        }

        return result;
    }
}
