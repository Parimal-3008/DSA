class Solution {
    public int swimInWater(int[][] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[2],b[2]));
        int n = arr.length;
        boolean[][] vis = new boolean[n][n];
        int[][] dp = new int[n][n];
        for(int i[]:dp)
            Arrays.fill(i,Integer.MAX_VALUE);
        pq.add(new int[]{0,0,arr[0][0]});
        vis[0][0]=true;
        dp[0][0]=arr[0][0];
        while(!pq.isEmpty())
        {
            int temp[]= pq.poll();int i=temp[0];int j=temp[1];int k=temp[2];
            vis[i][j]=true;
            if(i==n-1 && j==n-1)
                return dp[i][j];
            if(i+1<n&& !vis[i+1][j] && dp[i+1][j]>Math.max(dp[i][j],arr[i+1][j]))
            {
                dp[i+1][j]=Math.max(dp[i][j],arr[i+1][j]);
                 pq.add(new int[]{i+1,j,dp[i+1][j]});
            }
            if(i-1>=0&& !vis[i-1][j] && dp[i-1][j]>Math.max(dp[i][j],arr[i-1][j]))
            {
                dp[i-1][j]=Math.max(dp[i][j],arr[i-1][j]);
                 pq.add(new int[]{i-1,j,dp[i-1][j]});
            }
             if(j+1<n&& !vis[i][j+1] && dp[i][j+1]>Math.max(dp[i][j],arr[i][j+1]))
            {
                dp[i][j+1]=Math.max(dp[i][j],arr[i][j+1]);
                 pq.add(new int[]{i,j+1,dp[i][j+1]});
            }
            if(j-1>=0&& !vis[i][j-1] && dp[i][j-1]>Math.max(dp[i][j],arr[i][j-1]))
            {
                dp[i][j-1]=Math.max(dp[i][j],arr[i][j-1]);
                 pq.add(new int[]{i,j-1,dp[i][j-1]});
            }
            
        }
        return -10;
    }
}