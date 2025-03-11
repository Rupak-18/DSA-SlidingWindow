class Solution {

    public int countSubArray(int[] nums, int k) {
        if(k < 0)  return 0;
        int l = 0, r = 0;
        int count = 0;
        int n = nums.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        
        while(r < n) {
            mpp.put(nums[r], mpp.getOrDefault(nums[r], 0) + 1);
            while(mpp.size() > k) {
                mpp.put(nums[l], mpp.getOrDefault(nums[l], 0) - 1);
                if(mpp.get(nums[l]) == 0)
                    mpp.remove(nums[l]);
                l++;
            }
            count += r - l + 1;
            r++;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int atMost = countSubArray(nums, k);
        int atMostMinusOne = countSubArray(nums, k - 1);

        return atMost - atMostMinusOne;
    }

}