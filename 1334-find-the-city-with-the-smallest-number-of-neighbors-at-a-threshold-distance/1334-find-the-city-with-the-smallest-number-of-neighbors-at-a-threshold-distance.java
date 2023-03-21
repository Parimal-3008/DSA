class Solution {
  class Node 
  {
    int ind;int dist;
    public Node(int ind,int dist)
    {
      this.ind=ind;this.dist=dist;
    }
  }
  class edgecom implements Comparator<Node>
  {
    @Override
    public int compare(Node n1,Node n2)
    {
      return Integer.compare(n1.dist,n2.dist);
    }
  }
    public int findTheCity(int n, int[][] edges, int k) {
        int arr[][]= new int[n][n];
      for(int i[]:edges)
      {
        arr[i[0]][i[1]]=i[2];
        arr[i[1]][i[0]]=i[2];
      }
      int arr2[]= new int[n];
      for(int i=0;i<n;i++)
      {
        int dp[]= new int[n];
        PriorityQueue<Node> pq = new PriorityQueue<>(new edgecom());
        Arrays.fill(dp,Integer.MAX_VALUE);
        pq.add(new Node(i,0));
        dp[i]=0;
        while(!pq.isEmpty())
        {
          Node p = pq.poll();
          for(int j=0;j<n;j++)
          {
           
            if(arr[p.ind][j]!=0 && p.dist+arr[p.ind][j]<dp[j])
            {
              dp[j] = p.dist+arr[p.ind][j];
              pq.add(new Node(j,dp[j]));
            }
          }
        }
       
       for(int j=0;j<n;j++)
       {
         // System.out.print(dp[j]+" ");
         if(j!=i && dp[j]<=k)
           arr2[i]++;
       }
        // System.out.println();
      }
      int min =500000;
      int ind =0;
      for(int i=0;i<n;i++)
      {
        System.out.print(arr2[i]+" ");
        if(min>=arr2[i])
        {
          min = arr2[i];
          ind = i;
        }        
      }
      return ind;
    }
}