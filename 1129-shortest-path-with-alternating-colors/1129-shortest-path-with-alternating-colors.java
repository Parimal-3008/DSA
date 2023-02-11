class Solution {
  class Node
  {
    int n;int color;int wt;
    public Node(int n,int color,int wt)
    {
      this.n = n;
      this.wt = wt;
      this.color = color;
    }
  }
  class comp implements Comparator<Node>
  {
    @Override
    public int compare(Node n1,Node n2)
    {
     return Integer.compare(n1.wt,n2.wt);
    }
  }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int red[][]= new int[n][n];
      int blue[][]= new int[n][n];
      //1 red
      //2 blue
      for(int i[]:redEdges)
      {
        red[i[0]][i[1]]=1;
      }
      for(int i[]:blueEdges)
      {
        blue[i[0]][i[1]]=1;
      }
      int dist[]= new int[n];//blue
      int dist2[]= new int[n];//red
      Arrays.fill(dist,1000);
      Arrays.fill(dist2,1000);
      PriorityQueue<Node> pq = new PriorityQueue<>(new comp());
      pq.add(new Node(0,0,0));
      dist[0]=0;dist2[0]=0;
      while(!pq.isEmpty())
      {
        Node p= pq.poll();
        int col = p.color;
        if(col==1)
        {
          for(int i=0;i<n;i++)
          {
            if(blue[p.n][i]==1 && dist2[p.n]+1<dist[i])
            {             
                dist[i]=dist2[p.n]+1;
                pq.add(new Node(i,2,dist[i]));              
            }
          }
        }
          else if(col==2)
          {
            for(int i=0;i<n;i++)
          {
            if(red[p.n][i]==1 && dist[p.n]+1<dist2[i])
            {              
                dist2[i]=dist[p.n]+1;
                pq.add(new Node(i,1,dist2[i]));            
            }
          }
          }
          else
          {
            for(int i=0;i<n;i++)
          {
           if(blue[p.n][i]==1 && dist2[p.n]+1<dist[i])
            {             
                dist[i]=dist2[p.n]+1;
                pq.add(new Node(i,2,dist[i]));              
            }
              if(red[p.n][i]==1 && dist[p.n]+1<dist2[i])
            {              
                dist2[i]=dist[p.n]+1;
                pq.add(new Node(i,1,dist2[i]));            
            }
          }
            
          }
          
      }
      // for(int i:dist2)
      //   System.out.print(i+" ");
      // System.out.println();
      // for(int i:dist)
      //   System.out.print(i+" ");
      // System.out.println();
      for(int i= 0;i<n;i++)
      {
        dist[i]=Math.min(dist[i],dist2[i]);
        if(dist[i]>=1000)
          dist[i]=-1;
      
        
      }
      
      // dist[0]=0;
      return dist;
    }
}