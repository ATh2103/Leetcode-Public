class Solution {
    public int characterReplacement(String s, int k) {
        int l0 = 1;
        int h1 = s.length()+1;
        
        while(l0+1 < h1){
            int mid = l0 + (h1-l0)/2;
            
            if(canMakeValidSub(s, mid, k)){
                l0 = mid;
            }else{
                h1 = mid;
            }
        }
        return l0;
    }
    
    // take a window of length `substringLength` on the given string, and move it from left to right. If this window satisfies the condition of a valid string, then we return true
    private Boolean canMakeValidSub(String s, int mid, int k){
        int[] freqMap = new int[26];
        int maxFreq = 0 , start = 0;
        for(int i = 0; i<s.length(); i++){
            freqMap[s.charAt(i) - 'A'] += 1;
            if(i+1-start > mid){
                freqMap[s.charAt(start) - 'A'] -= 1;
                start++;
            }
            maxFreq = Math.max(maxFreq , freqMap[s.charAt(i) - 'A']);
            if(mid - maxFreq <= k)  return true;
        }
        return false;
    }
}