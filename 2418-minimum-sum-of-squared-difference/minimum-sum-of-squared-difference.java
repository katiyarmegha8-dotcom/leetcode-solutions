class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k = (long) k1 + k2;

        int n = nums1.length;
        long[] diff = new long[n];

        long total = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            total += diff[i];
            maxDiff = Math.max(maxDiff, (int) diff[i]);
        }

        if (k >= total) return 0;

        int left = 0, right = maxDiff;

        while (left < right) {
            int mid = left + (right - left) / 2;

            long need = 0;

            for (long d : diff) {
                if (d > mid) {
                    need += d - mid;
                }
            }

            if (need > k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int target = left;

        long used = 0;

        for (int i = 0; i < n; i++) {
            if (diff[i] > target) {
                used += diff[i] - target;
                diff[i] = target;
            }
        }

        long remain = k - used;

        for (int i = 0; i < n && remain > 0; i++) {
            if (diff[i] == target) {
                diff[i]--;
                remain--;
            }
        }

        long ans = 0;

        for (long d : diff) {
            ans += d * d;
        }

        return ans;
    }
}