class Solution {
    public int lengthOfLongestSubstring(String str) {
      int l =1;// worst case we can get our ans is 1
      int r =str.length();// best case we can get our answer is entire string length
      int ans =0;
        while(l<=r)
        {
          int mid = (l+r)/2;
          if(ispossible(mid,str))
          {
            ans = mid;
            // since we want longest we will move to rhs part of search window
            l = mid+1;
          }
          else // we didnt got our answer
            r = mid-1;
        }
      return ans;
    }
  public boolean ispossible(int len,String str)
  {
     Map<Character,Integer> mp = new HashMap<>();
    for(int i=0;i<len;i++)
    {
      char ch = str.charAt(i);
      if(mp.containsKey(ch))
         mp.put(str.charAt(i),mp.get(ch)+1);
         else
         mp.put(ch,1);
    }
    if(mp.size()==len)
      return true;
    for(int i=len;i<str.length();i++)
    {
      char ch = str.charAt(i);
      char t= str.charAt(i-len);
      mp.put(t,mp.get(t)-1);
      if(mp.get(t)==0)
        mp.remove(t);
      if(mp.containsKey(ch))
         mp.put(str.charAt(i),mp.get(ch)+1);
         else
         mp.put(ch,1);
      if(mp.size()==len)
      return true;
    }
    return false;
  }
}