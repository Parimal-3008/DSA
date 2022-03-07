class Solution {
    class Edge
    {
        int x; int y;
        public Edge(int x, int y)
        {
            this.x=x;this.y=y;
        }
    }
    public int[][] updateMatrix(int[][] arr) {
        int m =arr.length;
        int n =arr[0].length;
        Queue<Edge> q = new LinkedList<>();
        int dist[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==0)
                   { q.add(new Edge(i,j));
                    dist[i][j]=0;}
                else
                    dist[i][j]=Integer.MAX_VALUE;
            }
        }
        int temp[][]={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            Edge e= q.poll();
            for(int i[]:temp)
            {
                int p1= e.x+i[0];int p2=e.y+i[1];
                if(p1<0||p2<0||p1==m||p2==n)
                    continue;
                if(dist[e.x][e.y]+1<dist[p1][p2])
                {
                    q.add(new Edge(p1,p2));
                    dist[p1][p2]=dist[e.x][e.y]+1;
                }
            }
        }
        return dist;
        
        
    }
}