class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIndex = 0, maxIndex = 0;

        // Find indices of min and max
        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIndex]) minIndex = i;
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }

        // Ensure minIndex < maxIndex for easier calculation
        if (minIndex > maxIndex) {
            int temp = minIndex;
            minIndex = maxIndex;
            maxIndex = temp;
        }

        // Three possible strategies
        int deleteFromFront = maxIndex + 1;                 // remove both from front
        int deleteFromBack = n - minIndex;                  // remove both from back
        int deleteMixed = (minIndex + 1) + (n - maxIndex);  // one from front, one from back

        // Return the minimum deletions
        return Math.min(deleteFromFront, Math.min(deleteFromBack, deleteMixed));
    }
}
