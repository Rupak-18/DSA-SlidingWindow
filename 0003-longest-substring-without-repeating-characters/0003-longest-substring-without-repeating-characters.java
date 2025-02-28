class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        int n = s.length();
        int left = 0, right = 0;
        int maxLen = 0, len = 0;
        Arrays.fill(hash, -1);
        while(right < n) {
            if(hash[s.charAt(right)] != -1) {
                if(hash[s.charAt(right)] >= left) {
                    left = hash[s.charAt(right)]+1;
                }
            }
            len = right-left+1;
            maxLen = Math.max(maxLen, len);
            hash[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
}