class Solution {
    class Edge
    {
        int x; int y; int val;
        public Edge(int x, int y)
        {
            this.x=x;
            this.y=y;         
        }
    }  
    public int shortestPathBinaryMatrix(int[][] arr) {
        Edge or= new Edge(0,0);int n = arr.length;
        int dist[][] = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                dist[i][j]=Integer.MAX_VALUE;
        dist[0][0]=0;
        Queue<Edge> q = new LinkedList<>();
        if(arr[0][0] == 1) 
            return -1;
        if(arr[arr.length-1][arr.length-1]==1)
            return -1;
        q.add(or); int temp[][]= {{1,1},{1,-1},{-1,1},{-1,-1},{0,1},{0,-1},{1,0},{-1,0}};        
        while(!q.isEmpty())
        {
            Edge e= q.poll(); //System.out.println("new edge:"+e.x+" "+e.y+" "+dist[e.x][e.y]);
            for(int i[]:temp)
            {
                int p1 = e.x+i[0];int p2=e.y+i[1];
               //System.out.println(p1+" "+p2);
                if(p1<0||p1==n||p2<0||p2==n)
                    continue;
                if(arr[p1][p2]==1)
                    continue;
                if(dist[e.x][e.y]+1<dist[p1][p2])
                {   
                    dist[p1][p2]=dist[e.x][e.y]+1;
                    q.add(new Edge(p1,p2));
                }
            }
          }
        if(dist[n-1][n-1]==Integer.MAX_VALUE)
            return -1;
           return dist[n-1][n-1]+1; 
        
    }
}