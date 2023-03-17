class Solution {
    public int longestSubsequence(String str, int k) {
        int curr=0;
      int ans =0;int pow =0;
      for(int i=str.length()-1;i>=0;i--)
      {
        char ch = str.charAt(i);
        if(ch=='0')
        {
          ans++;
          pow++;
        }
        else
        {
          if(pow>31)
            continue;
          if(curr+(Math.pow(2,pow))<=k)
          {
            curr+=Math.pow(2,pow);
            ans++;pow++;
          }
        }
      }
      return ans;
    }
}