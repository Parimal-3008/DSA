class Solution {
    public int characterReplacement(String str, int k2) {
       int[] arr= new int[26];
        
        int l = 0;
        int ans = 0;
        int maxfreq=1;
        for(int i=0;i<str.length();i++)
        {
            char ch = str.charAt(i);
            arr[ch-'A']++;
            if(maxfreq<arr[ch-'A'])
            {
                maxfreq=arr[ch-'A'];
            }
            if(i-l+1 - maxfreq>k2)
            {
                arr[str.charAt(l)-'A']--;
                l++;
                 
            }
           ans = Math.max(ans,i-l+1);
        }
        return ans;
    }
}