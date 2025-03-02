class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        while(r < n) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            int len = r - l + 1;
            int count = len - maxFreq;
            if(count <= k)
                maxLen = Math.max(maxLen, len);
            
            while(count > k) {
                char ch = s.charAt(l);
                map.put(ch, map.getOrDefault(ch, 0) - 1);
                l++;
                maxFreq = Math.max(maxFreq, map.get(ch));
                len = r - l + 1;
                count = len - maxFreq;
                if(count <= k)
                    maxLen = Math.max(maxLen, len); 
            }
            r++;
        }

        return maxLen;
    }
}