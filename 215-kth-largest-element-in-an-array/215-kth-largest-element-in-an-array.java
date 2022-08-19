class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> Integer.compare(a,b));
      int a=0;
      for(int i:arr)
      {
        pq.offer(i);
        a++;
        if(a>k)
        {  pq.poll();a--;}
       
      }
      return pq.peek();
    }
}