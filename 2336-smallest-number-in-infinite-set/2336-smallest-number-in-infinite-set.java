class SmallestInfiniteSet {
   PriorityQueue<Integer> pq = new PriorityQueue<>();
   int arr[]= new int[10001];
    public SmallestInfiniteSet() {
        pq  = new PriorityQueue<>();
      for(int i=1;i<10001;i++)
      {
        pq.add(i);
        arr[i]=1;

      }
    }
    
    public int popSmallest() {
        int b= pq.poll();
      arr[b]=0;
      return b;
    }
    
    public void addBack(int num) {
        if(arr[num]==0)
        {
          arr[num]=1;
          pq.offer(num);
          
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */