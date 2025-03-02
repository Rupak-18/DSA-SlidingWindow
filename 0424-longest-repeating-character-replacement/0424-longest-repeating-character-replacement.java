class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int n = s.length();
        int[] hash = new int[26];

        while (r < n) {
            char c = s.charAt(r);
            // Update frequency of current character
            hash[c - 65]++; 
            maxFreq = Math.max(maxFreq, hash[c - 65]);
            int len = r - l + 1;
            // Number of characters to replace
            int count = len - maxFreq; 
            
            // If replacements exceed k, shrink the window
            if (count > k) { 
                char ch = s.charAt(l);
                hash[ch - 65]--;
                l++;
            } 
            // Update maximum valid window length
            else {
                maxLen = Math.max(maxLen, len); 
            }
            r++;
        }

        return maxLen;
    }
}
