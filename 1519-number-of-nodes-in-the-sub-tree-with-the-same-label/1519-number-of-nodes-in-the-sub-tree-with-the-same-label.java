class Solution {
    public int[] countSubTrees(int n, int[][] arr, String str) {
        List<List<Integer>> list = new ArrayList<>();
      for(int i=0;i<=n;i++)
        list.add(new ArrayList<>());
      for(int i[]:arr)
      {
        list.get(i[0]).add(i[1]);
        list.get(i[1]).add(i[0]);
      }
      int ans[]= new int[n];
      boolean vis[]= new boolean[n];
      Map<Character,Integer> mp = new HashMap<>();
      call(0,list,vis,mp,ans,str);
    
      return ans;
      
    }
  public void call(int i, List<List<Integer>> list, boolean[] vis,Map<Character,Integer> mp,int[] ans,String str)
  {
     vis[i]=true;
    Map<Character,Integer> mp2 = new HashMap<>();
    mp2.put(str.charAt(i),1);
    for(int j:list.get(i))
    {
       if(!vis[j])
       {
        call(j,list,vis,mp2,ans,str);
       }      
    }
      
    ans[i]=1;
    if(mp2.containsKey(str.charAt(i)))
      ans[i]+=(mp2.get(str.charAt(i))-1);
    for(Map.Entry<Character,Integer> entry:mp2.entrySet())
    {
      char k = entry.getKey();
      int val= entry.getValue();
       if(mp.containsKey(k))
         mp.put(k,mp.get(k)+val);
      else
        mp.put(k,val);
    }
    
  }
}