class Solution {
  int start =-1;
  int end =-1;
    public String minWindow(String s, String t) {
        int l = t.length();
      int r = s.length();
      Map<Character,Integer> mp1 = new HashMap<>();
      Map<Character,Integer> mp2 = new HashMap<>();
      for(int i=0;i<t.length();i++)
      {
        char c= t.charAt(i);
        if(mp2.containsKey(c))
          mp2.put(c,mp2.get(c)+1);
        else
          mp2.put(c,1);        
      }
      System.out.println(mp2);
      int ans =-1;
      while(l<=r)
      {
        int mid = (l+r)/2;
        if(ispossible(mid,mp2,s))
        {
          ans = mid;
          r = mid-1;
        }
        else
          l= mid+1;
      }
      System.out.println(start+" "+ans);
      if(ans==-1)
        return "";
      return s.substring(start,start+ans);
      
    }
  public boolean ispossible(int len,Map<Character,Integer> mp2, String s)
  {
      Map<Character,Integer> mp1 = new HashMap<>();
    for(int i=0;i<len;i++)
    {
      char c= s.charAt(i);
        if(mp1.containsKey(c))
          mp1.put(c,mp1.get(c)+1);
        else
          mp1.put(c,1);
    }
    if(call2(mp1,mp2))
    {
      start = 0;end = len-1;return true;
    }
    for(int i=len;i<s.length();i++)
    {
       mp1.put(s.charAt(i-len),mp1.get(s.charAt(i-len))-1);
      char c = s.charAt(i);
      if(mp1.containsKey(c))
       mp1.put(c,mp1.get(c)+1);
      else
        mp1.put(c,1);
      if(call2(mp1,mp2))
      {
        start = i-len+1;end = i+1;
        return true;
      }
    }
    return false;
  }
  public boolean call2(Map<Character,Integer> mp1,Map<Character,Integer> mp2 )
  {
    // System.out.println(mp1+" "+mp2);
    for(Map.Entry<Character,Integer> entry:mp2.entrySet())
      {
        char k = entry.getKey();
        int v = entry.getValue();
        if(!mp1.containsKey(k)) return false;
        if(mp1.get(k)<v)
          return false;
      }
    return true;
  }
}