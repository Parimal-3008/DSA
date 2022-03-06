class Solution {
    class Edge
    {
        int x; int y;
        public Edge(int x, int y)
        {
            this.x=x;this.y=y;
        }
    }
    public int nearestExit(char[][] arr, int[] op) {
        Edge or= new Edge(op[0],op[1]);
        int m = arr.length;int n = arr[0].length;
        int dist[][]= new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                dist[i][j]=Integer.MAX_VALUE;
        dist[or.x][or.y]=0;
         Queue<Edge> q = new LinkedList<>();
        q.add(or);
        int temp[][]={{1,0},{0,1},{-1,0},{0,-1}};
        int min=Integer.MAX_VALUE;
        while(!q.isEmpty())
        {
            Edge e= q.poll();
           // System.out.println("New edge: "+e.x+" "+e.y+" "+dist[e.x][e.y]);
            for(int i[]:temp)
            {
                int p1=e.x+i[0];int p2=e.y+i[1];
                if(p1<0||p1==m||p2<0||p2==n||arr[p1][p2]=='+')
                    continue;
                if(dist[e.x][e.y]+1<dist[p1][p2])
                {
                    q.add(new Edge(p1,p2));
                     //System.out.println(p1+" "+p2);
                    dist[p1][p2]=dist[e.x][e.y]+1;   
                    if((p1==0||p1==m-1||p2==0||p2==n-1)&&!(p1==op[0]&&p2==op[1]))
                       min=Math.min(min,dist[p1][p2]);
                }                    
            }
        }
        if(min==Integer.MAX_VALUE)
            return -1;
        return min;
        
    }
}