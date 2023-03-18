class Solution {
  class Node
  {
    int n;double prob;
    public Node(int n, double prob)
    {
      this.n=n;
      this.prob=prob;
    }
  }
  class probcom implements Comparator<Node>
  {
     @Override
    public int compare(Node n1,Node n2)
    {
      return Double.compare(n2.prob,n1.prob);
    }
  }
    public double maxProbability(int n, int[][] edges, double[] prob, int start, int end) {
        List<List<Integer>> list = new ArrayList<>();
      for(int i=0;i<=n;i++)
        list.add(new ArrayList<>());
      double dp[]= new double[n+1];
      Arrays.fill(dp,0.0);
      Map<String,Double> mp = new HashMap<>();
      for(int i=0;i<edges.length;i++)
      {
        int a = edges[i][0];
        int b = edges[i][1];
        list.get(a).add(b);
        list.get(b).add(a);
        mp.put(String.valueOf(a)+";"+String.valueOf(b),prob[i]);        
        mp.put(String.valueOf(b)+";"+String.valueOf(a),prob[i]);
      }
      PriorityQueue<Node> pq = new PriorityQueue<>(new probcom());
      dp[start] = 1.0;
      pq.add(new Node(start,0));
      while(!pq.isEmpty())
      {
        Node n1 = pq.poll();
        for(Integer i:list.get(n1.n))
        {
          String str = String.valueOf(n1.n)+";"+String.valueOf(i);
          if(dp[n1.n]*mp.get(str)>dp[i])
          {
            dp[i] = dp[n1.n]*mp.get(str);
            pq.add(new Node(i, dp[i]));
          }
        }
      }
      return dp[end];
    }
}