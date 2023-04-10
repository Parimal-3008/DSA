class Solution {
    public int numSquarefulPerms(int[] arr) {
      Map<Integer,Integer> mp =  new HashMap<>();
      for(int i:arr)
      {
        if(mp.containsKey(i))
          mp.put(i,mp.get(i)+1);
        else
          mp.put(i,1);
      }
       return call(mp,-1);
    }
  public int call(Map<Integer,Integer> mp, int prev)
  {
     if(mp.isEmpty())
       return 1;
    Map<Integer,Integer> mp2 = new HashMap<>();
    int ans = 0;
    for(Map.Entry<Integer,Integer> entry:mp.entrySet())
    {
      mp2.put(entry.getKey(),entry.getValue());
    }
    for(Map.Entry<Integer,Integer> entry:mp.entrySet())
    {
      int k = entry.getKey();
      int v = entry.getValue();
      if(prev==-1 || check(prev,k))
    {
        if(v-1>0)
          mp2.put(k,v-1);
        else
          mp2.remove(k);
        ans+=call(mp2,k);
        mp2.put(k,v);
     }

    }
    return ans;
  }
  public boolean check(int a, int b)
  {
    if(a==-1)
      return true;
    double tot = a+b;
    int p = (int)Math.sqrt(tot);
    return (p*p)==(a+b);
  }
  
}