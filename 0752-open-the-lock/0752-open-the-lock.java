class Solution {
  class Edge
  {
    int a;int b;int c;int d; int dist;
    public Edge(int a,int b,int c, int d, int dist)
    {
      this.a= a;this.b=b;this.c=c;this.d=d;
      this.dist = dist;
    }
  }
  public class edgecom implements Comparator<Edge>
  {
    @Override
    public int compare(Edge e1,Edge e2)
    {
      return Integer.compare(e1.dist,e2.dist);
    }
  }
    public int openLock(String[] deadends, String target) {
        HashSet<String> set = new HashSet<>();
      for(String i:deadends)
        set.add(i);
      int[][][][] dp= new int[10][10][10][10];
      for(int i[][][]:dp)
        for(int j[][]:i)
          for(int k[]:j)
            Arrays.fill(k,Integer.MAX_VALUE);
      PriorityQueue<Edge> pq = new PriorityQueue<>(new edgecom());
      pq.add(new Edge(0,0,0,0,0));
     // System.out.println(set);
      dp[0][0][0][0]=0;
      while(!pq.isEmpty())
      {
        Edge e = pq.poll();
        if(set.contains(String.valueOf(e.a)+String.valueOf(e.b)+String.valueOf(e.c)+String.valueOf(e.d)))
          continue;
        // System.out.println(e.a+" "+e.b+" "+e.c+" "+e.d+" "+e.dist);
        if(dp[e.a+1>9?0:e.a+1][e.b][e.c][e.d]>e.dist+1)
        {
         String str=String.valueOf(e.a+1>9?0:e.a+1)+String.valueOf(e.b)+String.valueOf(e.c)+String.valueOf(e.d);
          // System.out.println(str +":::::"+set.contains(str));
          if(!set.contains(str))
          {
            dp[e.a+1>9?0:e.a+1][e.b][e.c][e.d]=e.dist+1;
            pq.add(new Edge(e.a+1>9?0:e.a+1,e.b,e.c,e.d,e.dist+1));
          }
        }
        if(dp[e.a-1<0?9:e.a-1][e.b][e.c][e.d]>e.dist+1)
        {
          String str=String.valueOf(e.a-1<0?9:e.a-1)+String.valueOf(e.b)+String.valueOf(e.c)+String.valueOf(e.d);
          // System.out.println(str+":::::"+set.contains(str));
          if(!set.contains(str))
          {
            dp[e.a-1<0?9:e.a-1][e.b][e.c][e.d]=e.dist+1;
            pq.add(new Edge(e.a-1<0?9:e.a-1,e.b,e.c,e.d,e.dist+1));
          }
        }
        
        if(dp[e.a][e.b+1>9?0:e.b+1][e.c][e.d]>e.dist+1)
        {
        String  str=String.valueOf(e.a)+String.valueOf(e.b+1>9?0:e.b+1)+String.valueOf(e.c)+String.valueOf(e.d);
         // System.out.println(str+":::::"+set.contains(str));
          if(!set.contains(str))
          {
            dp[e.a][e.b+1>9?0:e.b+1][e.c][e.d]=e.dist+1;
            pq.add(new Edge(e.a,e.b+1>9?0:e.b+1,e.c,e.d,e.dist+1));
          }
        }
        if(dp[e.a][e.b-1<0?9:e.b-1][e.c][e.d]>e.dist+1)
        {
         String str=String.valueOf(e.a)+String.valueOf(e.b-1<0?9:e.b-1)+String.valueOf(e.c)+String.valueOf(e.d);
         // System.out.println(str+":::::"+set.contains(str));
          if(!set.contains(str))
          {
            dp[e.a][e.b-1<0?9:e.b-1][e.c][e.d]=e.dist+1;
            pq.add(new Edge(e.a,e.b-1<0?9:e.b-1,e.c,e.d,e.dist+1));
          }
        }
        
         if(dp[e.a][e.b][e.c+1>9?0:e.c+1][e.d]>e.dist+1)
        {
         String str=String.valueOf(e.a)+String.valueOf(e.b)+String.valueOf(e.c+1>9?0:e.c+1)+String.valueOf(e.d);
        // System.out.println(str+":::::"+set.contains(str));
           if(!set.contains(str))
          {
            dp[e.a][e.b][e.c+1>9?0:e.c+1][e.d]=e.dist+1;
            pq.add(new Edge(e.a,e.b,e.c+1>9?0:e.c+1,e.d,e.dist+1));
          }
        }
        if(dp[e.a][e.b][e.c-1<0?9:e.c-1][e.d]>e.dist+1)
        {
         String str=String.valueOf(e.a)+String.valueOf(e.b)+String.valueOf(e.c-1<0?9:e.c-1)+String.valueOf(e.d);
         // System.out.println(str+":::::"+set.contains(str));
          if(!set.contains(str))
          {
            dp[e.a][e.b][e.c-1<0?9:e.c-1][e.d]=e.dist+1;
            pq.add(new Edge(e.a,e.b,e.c-1<0?9:e.c-1,e.d,e.dist+1));
          }
        }
        
        if(dp[e.a][e.b][e.c][e.d+1>9?0:e.d+1]>e.dist+1)
        {
         String str=String.valueOf(e.a)+String.valueOf(e.b)+String.valueOf(e)+String.valueOf(e.d+1>9?0:e.d+1);
         // System.out.println(str+":::::"+set.contains(str));
          if(!set.contains(str))
          {
            dp[e.a][e.b][e.c][e.d+1>9?0:e.d+1]=e.dist+1;
            pq.add(new Edge(e.a,e.b,e.c,e.d+1>9?0:e.d+1,e.dist+1));
          }
        }
        if(dp[e.a][e.b][e.c][e.d-1<0?9:e.d-1]>e.dist+1)
        {
         String str=String.valueOf(e.a)+String.valueOf(e.b)+String.valueOf(e.c)+String.valueOf(e.d-1<0?9:e.d-1);
         // System.out.println(str+":::::"+set.contains(str));
          if(!set.contains(str))
          {
            dp[e.a][e.b][e.c][e.d-1<0?9:e.d-1]=e.dist+1;
            pq.add(new Edge(e.a,e.b,e.c,e.d-1<0?9:e.d-1,e.dist+1));
          }
        }
        
        
      }
      int p = dp[Integer.parseInt(String.valueOf(target.charAt(0)))][Integer.parseInt(String.valueOf(target.charAt(1)))][Integer.parseInt(String.valueOf(target.charAt(2)))][Integer.parseInt(String.valueOf(target.charAt(3)))];
      return p!=Integer.MAX_VALUE?p:-1;      
    }
 
}