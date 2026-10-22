class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < n; i++) {
            int next = nums[(i + 1) % n];

            if (next != (nums[i] + 1) % n) {
                inc = false;
            }

            if (next != (nums[i] - 1 + n) % n) {
                dec = false;
            }
        }

        int pos0 = 0;
        while (nums[pos0] != 0) pos0++;

        int ans = Integer.MAX_VALUE;

        if (inc) {
            // Rotate left pos0 times
            ans = Math.min(ans, pos0);

            // Reverse -> rotate -> reverse
            ans = Math.min(ans, n - pos0 + 2);
        }

        if (dec) {
            // Reverse first, then rotate
            ans = Math.min(ans, n - pos0);

            // Rotate first, then reverse
            ans = Math.min(ans, pos0 + 2);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}