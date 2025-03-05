class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0;
        int r = 0;
        int n = s.length();
        int count = 0;
        int[] hash = new int[3];
        Arrays.fill(hash, -1);
        while(r < n) {
            char c = s.charAt(r);
            hash[c - 'a'] = r;
            if(hash[0] != -1 && hash[1] != -1 && hash[2] != -1) {
                l = Math.min((Math.min(hash[0], hash[1])), hash[2]);
                count += l + 1;
            }
            r++;
        }
        return count++;
    }
}