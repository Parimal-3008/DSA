class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[][] dp= new int[n][3];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=arr[i];
            dp[i][1]=i;
            dp[i][2]=0;
        }
        int[] ans = new int[n-k+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<k;i++)
         {
            pq.add(dp[i]);
             ans[0]=Math.max(ans[0],arr[i]);
         }
        for(int i=k;i<n;i++)
        {
            dp[i-k][2]=1;
            pq.add(dp[i]);
            while(!pq.isEmpty() && pq.peek()[2]==1)
                pq.poll();
            ans[i-k+1]=pq.peek()[0];
        }
        return ans;
        
        
    }
}