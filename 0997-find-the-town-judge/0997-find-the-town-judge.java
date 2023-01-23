class Solution {
    public int findJudge(int n, int[][] arr)
    {
      if(arr.length==0)
      {
        if(n==1)
          return n;
        return -1;
      }
     Map<Integer,Integer> mp = new HashMap<>();
      for(int i[]:arr)
         mp.put(i[1],mp.getOrDefault(i[1],0)+1);       
      Set<Integer> set = new HashSet<>();
      for(Map.Entry<Integer,Integer> entry:mp.entrySet())
      {
         if(entry.getValue()==n-1)
           set.add(entry.getKey());
      }
      for(int i[]:arr)
      {
        if(set.contains(i[0]))
          set.remove(i[0]);
          
      }
      if(set.size()!=1)
      return -1;
      for(int i:set)
        return i;
      return -1;
    }
}