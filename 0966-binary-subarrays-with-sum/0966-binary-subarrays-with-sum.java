class Solution {
    public int countSubArray(int[] nums, int k) {
        if(k < 0)  return 0;
        int l = 0, r = 0;
        int count = 0;
        int sum = 0;
        int n = nums.length;
        
        while(r < n) {
            sum += nums[r];
            while(sum > k) {
                sum -= nums[l];
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int atMostGoal = countSubArray(nums, goal);
        int atMostGoalMinusOne = countSubArray(nums, goal - 1);

        return atMostGoal - atMostGoalMinusOne;
    }
}