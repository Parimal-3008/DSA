class Solution {
  class Edge
  {
    int n;int dist;
    public Edge(int n, int dist)
    {
      this.n = n;
      this.dist = dist;
    }
  }
  class edgecom implements Comparator<Edge>
  {
    @Override
    public int compare(Edge e1,Edge e2)
    {
      int res = Integer.compare(e1.dist,e2.dist);
      return res;
    }
  }
    public int minimumOperations(int[] arr, int start, int end) {
      int dp[]= new int[1001];
      Arrays.fill(dp,Integer.MAX_VALUE);
        dp[start] = 0;
      PriorityQueue<Edge> pq = new PriorityQueue<>(new edgecom());
      pq.add(new Edge(start,0));
      while(!pq.isEmpty())
      {
        Edge e = pq.poll();
        for(int i:arr)
        {
          int a = e.n+i;
          int b = e.n-i;
          int c = e.n^i;
          if(a>=0 && a<=1000)
          {
            if(e.dist+1<dp[a])
            {
              dp[a]= e.dist+1;
              pq.add(new Edge(a,dp[a]));
            }
          }
          else
          {
            if(end==a)
              return e.dist+1;
          }
         
        if(b>=0 && b<=1000)
          {
            if(e.dist+1<dp[b])
            {
              dp[b]= e.dist+1;
              pq.add(new Edge(b,dp[b]));
            }
          }
          else
          {
            if(end==b)
              return e.dist+1;
          }
         
      if(c>=0 && c<=1000)
          {
            if(e.dist+1<dp[c])
            {
              dp[c]= e.dist+1;
              pq.add(new Edge(c,dp[c]));
            }
          }
          else
          {
            if(end==c)
              return e.dist+1;
          }
        }
      }
      if(end<0 || end>1000)
        return -1;
      if(dp[end]==Integer.MAX_VALUE)
        return -1;
      return dp[end];

      
    }
}