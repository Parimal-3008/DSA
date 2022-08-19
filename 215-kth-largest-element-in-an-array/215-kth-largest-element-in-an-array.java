class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)-> b-a);
        for(int i=0;i<arr.length;i++)
        {
           
                pq.offer(arr[i]);
        }
        int y=0;
        while(pq.size()>0&&k-->0)
        {
             y=pq.poll();
        }
        return y;
    }
}