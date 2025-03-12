class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int l = 0, r = 0;
        Map<Character, Integer> mpp = new HashMap<>();
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = 0;

        for(char c : t.toCharArray()) {
            mpp.put(c, mpp.getOrDefault(c, 0) + 1);
        }

        while(r < n) {
            char c = s.charAt(r);
            if(mpp.containsKey(c) && mpp.get(c) > 0) 
                count++;
            mpp.put(c, mpp.getOrDefault(c, -1) - 1);

            while(count == t.length()) {
                if(r - l + 1 < minLength) {
                    startIndex = l;
                    minLength = r - l + 1;
                }
                char ch = s.charAt(l);
                mpp.put(ch, mpp.get(ch) + 1);
                if(mpp.get(ch) > 0)
                    count--;
                l++;
            }
            r++;
        }

        String str = (startIndex == -1) ? "" : s.substring(startIndex, startIndex +minLength);
        return str;
    }
}