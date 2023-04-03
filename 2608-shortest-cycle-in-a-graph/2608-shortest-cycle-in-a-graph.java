class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
      for(int i=0;i<=n;i++)
        list.add(new ArrayList<>());
      for(int i[]:edges)
      {
        list.get(i[0]).add(i[1]);
        list.get(i[1]).add(i[0]);
      }
      int max = Integer.MAX_VALUE;
      for(int j=0;j<n;j++)
      {
        int vis[]= new int[n];
        int parent[]= new int[n];
        
        Arrays.fill(vis,Integer.MAX_VALUE);
        Arrays.fill(parent,-1);
        Queue<Integer> q = new LinkedList<>();
        q.add(j);
        vis[j]=0;
        while(!q.isEmpty())
        {
          int u = q.poll();
          for(int i:list.get(u))
          {
             if(vis[i]>vis[u]+1)
             {
               vis[i]=vis[u]+1;
               q.add(i);
               parent[i]=u;
             }
            else if(parent[u]!=i && parent[i]!=u)
            {
              max= Math.min(max,Math.abs(vis[i]+vis[u])+1);
            }
           }
        }
      }
      return max==Integer.MAX_VALUE?-1:max;
    }
}