class Solution {
    public int minimumDeviation(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);//pops mas elemnt
       // PriorityQueue<Integer> pq2 = new PriorityQueue<>((a,b) -> a-b);// pops min element
        int diff = Integer.MAX_VALUE;int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]%2==1)
                arr[i]*=2;
            min=Math.min(min,arr[i]);
            pq.add(arr[i]);
        }
        while(pq.peek()%2==0)
        {
            int m = pq.poll();
            diff=Math.min(diff,m-min);
             min = Math.min(min,m/2);
            pq.add(m/2);
        }
      
        return Math.min(diff,-min+pq.peek());
        
    }
}