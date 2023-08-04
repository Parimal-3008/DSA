class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k,(a,b)->Integer.compare(b,a));
        for(int i:arr)
            pq.add(i);
        int ans = -1000000;
        while(k-->0)
            ans=pq.poll();
        return ans;
            
    }
}