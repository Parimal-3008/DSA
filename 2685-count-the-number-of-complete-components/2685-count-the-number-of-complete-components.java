class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
      for(int i=0;i<=50;i++)
        list.add(new ArrayList<>());
      for(int i[]:edges)
      {
        list.get(i[0]).add(i[1]);
        list.get(i[1]).add(i[0]);
        
      }
      boolean vis[]= new boolean[51];
      int ans = 0;
      for(int i=0;i<n;i++)
      {
        if(!vis[i])
        {
          boolean vis2[]= new boolean[51];
          call(i,vis,vis2,list);
          int tot = 0;
          int n2=0;
          for(int j=0;j<n;j++)
          {
            if(vis2[j])
            {
              n2++;
              tot+=list.get(j).size();
            }
          }
          if(n2*(n2-1) == tot)
            ans++;
        }
      }
      return ans;
    }
  public void call(int i,boolean[] vis, boolean[] vis2, List<List<Integer>> list)
  {
    vis[i]=true;
    vis2[i]=true;
    for(int j:list.get(i))
    {
      if(!vis2[j])
      {
        call(j,vis,vis2,list);
      }
    }

  }
}