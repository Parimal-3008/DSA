class Solution {
  class Edge
  {
    int index;int chair;int time;
    public Edge(int index,int chair,int time)
    {
      this.index=index;
      this.chair=chair;
      this.time=time;
    }
  }
  class edgecom implements Comparator<Edge>
  {
    @Override
    public int compare(Edge e1, Edge e2)
    {
      return Integer.compare(e1.time,e2.time);
    }
  }
    public int smallestChair(int[][] arr2, int k) {
      int arr[][]= new int[arr2.length][3];
      for(int i=0;i<arr.length;i++)
      {
        arr[i][0]=arr2[i][0];
        arr[i][1]=arr2[i][1];
        arr[i][2]=i;
      }
      Arrays.sort(arr,new Comparator<int[]>(){
        public int compare(int a[], int[] b)
        {
          return Integer.compare(a[0],b[0]);
        }
        
      });
      // for(int i[]:arr)
      //   System.out.println(i[0]+" "+i[1]+" "+i[2]);
      PriorityQueue<Integer> pq = new PriorityQueue<>();
      PriorityQueue<Edge> pq2 = new PriorityQueue<>(new edgecom());
      for(int i=0;i<100001;i++){
        pq.add(i);}
      int chair[]= new int[arr.length];
      for(int i=0;i<arr.length;i++)
      {
        while(!pq2.isEmpty() && pq2.peek().time<=arr[i][0])
        {
          Edge e = pq2.poll();
          // System.out.println(arr[i][2]+" "+e.index);
          pq.add(e.chair);
        }        
        chair[arr[i][2]]=pq.poll();
        pq2.add(new Edge(arr[i][2],chair[arr[i][2]],arr[i][1]));       
      }
      // for(int i:chair)
      //   System.out.print(i+" ");
      // System.out.println();
      return chair[k];
      // return 1;
    }
}