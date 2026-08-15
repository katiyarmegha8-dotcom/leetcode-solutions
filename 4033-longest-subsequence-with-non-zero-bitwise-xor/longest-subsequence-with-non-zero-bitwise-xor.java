class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // If overall XOR is non-zero, we can take the entire array
        if (xor != 0) {
            return nums.length;
        }
        // If XOR is zero:
        // - If all elements are zero, no subsequence can give non-zero XOR → return 0
        // - Otherwise, drop one element → return n-1
        boolean allZero = true;
        for (int num : nums) {
            if (num != 0) {
                allZero = false;
                break;
            }
        }
        if (allZero) {
            return 0;
        }
        return nums.length == 1 ? 0 : nums.length - 1;
    }
}



