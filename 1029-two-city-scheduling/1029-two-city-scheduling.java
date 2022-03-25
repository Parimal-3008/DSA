class Solution {
    class Edge
    {
        int a;int b;int diff;int ind;
        public Edge(int a,int b,int diff, int ind)
        {
            this.a=a;this.b=b;this.diff=diff;this.ind=ind;
        }
    }
    class comp implements Comparator<Edge>
    {
        @Override
        public int compare(Edge s1, Edge s2)
        {
            if(s1.diff>s2.diff)
                return 1;
            else if(s2.diff>s1.diff)
                return -1;
            else
            {
                if(s1.a>s2.a)
                    return -1;
                else
                    return 1;
            }
                
        }
    }
    public int twoCitySchedCost(int[][] arr) {
        int n=arr.length;
        PriorityQueue<Edge> pq= new PriorityQueue<Edge>(new comp());;
        for(int i=0;i<n;i++ )
            pq.add(new Edge(arr[i][0],arr[i][1],arr[i][1]-arr[i][0],i));
        int sum=0;
        int count=0;
        while(!pq.isEmpty())
        {
            
            Edge e =pq.poll();
          //  System.out.println(e.diff+" "+e.ind+" "+sum);
            if(count<n/2)
                sum+=e.b;
            else
                sum+=e.a;
            count++;
        }
        return sum;
        
    }
}