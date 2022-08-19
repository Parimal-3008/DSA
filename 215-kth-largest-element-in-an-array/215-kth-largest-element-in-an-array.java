class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(a,b));
      for(int i:arr)
      {
        pq.offer(i);
        if(pq.size()>k)
          pq.poll();
      }
      return pq.peek();
    }
}