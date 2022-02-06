class Solution {
    class Edge
    {
        int x;
        public Edge(int x)
            {this.x=x;}
    }
    class EdgeComparator implements Comparator<Edge>
    {
        @Override
        public int compare(Edge s1, Edge s2)
        {
            if(s1.x>=s2.x)
                return 1;
            else
                return -1;
        }
    }
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge> (k, new EdgeComparator());
        for(int i=0;i<arr.length;i++)
        {
            
            pq.offer(new Edge(arr[i]));
            if(pq.size()>k)
                pq.poll();
        }
        System.out.println(pq);
        int a=-1;
        // while(!pq.isEmpty()&&k>0)
        // {
        //     a = pq.poll().x;k--;
        // }
        return pq.peek().x;
    }
}