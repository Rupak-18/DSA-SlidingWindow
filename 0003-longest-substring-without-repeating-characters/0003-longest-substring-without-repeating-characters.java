class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int left = 0, right = 0;
        int maxLen = 0, len = 0;

        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        
        while(right < n) {
            char c = s.charAt(right);
            if(hash[c] != -1) {
                if(hash[c] >= left) {
                    left = hash[c] + 1;
                }
            }
            len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            hash[c] = right;
            right++;
        }
        return maxLen;
    }
}