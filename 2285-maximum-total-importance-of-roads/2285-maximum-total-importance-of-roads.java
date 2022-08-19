class Solution {
  class Edge
  {
    int city;int val;
    public Edge(int city, int val)
    {
      this.city = city;
      this.val= val;
    }
  }
  class Comp implements Comparator<Edge>
  {
    @Override
    public int compare(Edge e1, Edge e2)
    {
      int res = Integer.compare(e2.val,e1.val);
      return res;
    }
  }
    public long maximumImportance(int n, int[][] roads) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comp());
      int arr[]= new int[n];
      for(int i[]:roads)
      {
        arr[i[0]]++;
        arr[i[01]]++;
      }
      for(int i=0;i<n;i++)
      {
        pq.add(new Edge(i,arr[i]));
      }
      long sum=0;
      while(!pq.isEmpty())
      {
        sum+= ((long)pq.poll().val * (long)n);
           n--;
      }
      return sum;
    }
}