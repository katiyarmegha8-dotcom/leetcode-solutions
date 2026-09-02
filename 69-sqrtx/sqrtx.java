class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;  // Base cases

        int left = 1, right = x, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Compare mid with x/mid to avoid overflow
            if (mid <= x / mid) {
                ans = mid;       // mid is a valid candidate
                left = mid + 1;  // try to find a larger one
            } else {
                right = mid - 1; // shrink search space
            }
        }

        return ans;
    }
}
