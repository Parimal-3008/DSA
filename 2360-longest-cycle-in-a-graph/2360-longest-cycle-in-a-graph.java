class Solution {
    public int longestCycle(int[] arr) {
        int vis[]= new int[arr.length];
      // Arrays.fill(vis,-1);
      int max = -1;
      for(int i=0;i<arr.length;i++)
      {
        if(vis[i]==0 && arr[i]!=-1)
        {
          vis[i]=1;
          Set<Integer> set = new HashSet<>();
          set.add(i);
           max = Math.max(max,dfs(i,arr,vis,set));
          if(max!=-1)
            System.out.println(i);
        }
      }
      // for(int i:vis)
      //   System.out.print(i+" ");
      return max;
    }
  public int dfs(int i, int[] arr, int[] vis,Set<Integer> set)
  {
    if(arr[i]==-1)
      return -1;
    int max = -1;
    // set.add(i);
    // if(i==5 )
    // System.out.println(i+" "+set+" "+arr[i]+" "+set.contains(arr[i]));
   if(vis[arr[i]]==0)
       {
         vis[arr[i]]=vis[i]+1;  
         // System.out.println(i+" "+arr[i]);
         set.add(arr[i]);
        return dfs(arr[i],arr,vis,set);
       }
      else if(vis[arr[i]]!=0 && set.contains(arr[i]))
     {
      // System.out.println(i+" "+set);
      return Math.abs(vis[arr[i]]-vis[i])+1;
     }
    return -1;
  }
}