class Solution {
    class Edge
    {
        int src; int dest;int wt;
        public Edge( int b, int c)
        {
          //  this.src=a;
            this.dest=b;this.wt=c;
        }
    }
    class Comp implements Comparator<Edge>
    {
        @Override
        public int compare(Edge s1, Edge s2)
        {
            if(s1.wt<s2.wt)
                return -1;
            else if(s1.wt>s2.wt)
                return 1;
            else
                return 0;
        }
    }
    
    public int networkDelayTime(int[][] arr, int n, int k) {
        ArrayList<ArrayList<Edge>> list = new ArrayList<>();n++;
        for(int i=0;i<n;i++)
            list.add(new ArrayList<Edge>());
        for(int i[]:arr)
        {
            list.get(i[0]).add(new Edge(i[1],i[2]));
        }
        int dist[]= new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Edge> q = new PriorityQueue<Edge>(new Comp());
        q.add(new Edge(k,0));dist[k]=0;
        while(!q.isEmpty())
        {
            Edge e = q.poll();
            for(Edge i:list.get(e.dest))
            {
                //System.out.println(dist[i.dest]+" "+i.wt+" "+dist[e.dest]);
                if(dist[i.dest]>dist[e.dest]+i.wt)
                {
                    q.add(i);
                    dist[i.dest]=dist[e.dest]+i.wt;
                }
            }
        }
        int max=0;
        for(int i=1;i<n;i++)
           {
            //System.out.println(dist[i]); 
            max=Math.max(max,dist[i]);}
        if(max==Integer.MAX_VALUE)
            return -1;
        return max;
    }
}