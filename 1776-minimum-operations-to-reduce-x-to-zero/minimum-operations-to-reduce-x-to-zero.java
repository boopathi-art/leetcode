class Solution {
    public int minOperations(int[] nums, int x) {

        int n = nums.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }

        int target = totalSum - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return n;
        }

        int left = 0;
        int sum = 0;
        int maxLength = -1;

        for (int right = 0; right < n; right++) {

            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                int length = right - left + 1;
                maxLength = Math.max(maxLength, length);
            }
        }

        if (maxLength == -1) {
            return -1;
        }

        return n - maxLength;
    }
}