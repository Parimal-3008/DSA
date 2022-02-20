class Solution {
    class Edge 
    {
        int m;
        int n;
        public Edge(int m,int n)
        {
            this.m=m;
            this.n=n;
        } 
    }
    class EdgeComparator implements Comparator<Edge>
    {
        @Override
        public int compare(Edge s1,Edge s2)
        {
            if(s1.m<s2.m)
                return -1;
            else if(s1.m>s2.m)
                return 1;
          else
           {
               if(s1.n<s2.n)
                return 1;
            else 
                return -1;
           }
        }
    }
    public int removeCoveredIntervals(int[][] arr) {
        int n = arr.length;
       PriorityQueue<Edge> pq =new PriorityQueue( new EdgeComparator());
        for(int i=0;i<n;i++)
        {
           pq.add(new Edge(arr[i][0],arr[i][1]));
        }
        int j=0;
       while(!pq.isEmpty())
        {
           Edge e= pq.poll();
            arr[j][0]=e.m;
            arr[j][1]=e.n;
            System.out.println(arr[j][0]+" "+arr[j][1]);
            j++;
            
        }
        int count=0;
        j=0;
        for(int i=1;i<n;i++)
        {
            
            if(arr[j][1]>=arr[i][1])
            {
                count++;
            }
            else
                j=i;
        }
        return n-count;
    }
}