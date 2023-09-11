class Solution {
    public int minCost(int[][] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        pq.add(new int[]{0,0,0});
        int[][] dp = new int[arr.length][arr[0].length];
        for(int i[]:dp)
            Arrays.fill(i,Integer.MAX_VALUE);
        dp[0][0]=0;
        int m = arr.length; int n = arr[0].length;
        while(!pq.isEmpty())
        {
            int temp[]= pq.poll();
            int i = temp[0];
            int j = temp[1];
            int k = temp[2];
            if(i==m-1 && j==n-1)
                return dp[i][j];
            if(i+1<m)
            {
                if(arr[i][j]==3 && dp[i+1][j]>dp[i][j])
                {
                    dp[i+1][j]=dp[i][j];
                    pq.add(new int[]{i+1,j,dp[i+1][j]});
                }
                else if(dp[i+1][j]>dp[i][j]+1)
                {
                    dp[i+1][j]=dp[i][j]+1;
                    pq.add(new int[]{i+1,j,dp[i+1][j]});
                }
            }
            if(i-1>=0)
            {
                if(arr[i][j]==4 && dp[i-1][j]>dp[i][j])
                {
                    dp[i-1][j]=dp[i][j];
                    pq.add(new int[]{i-1,j,dp[i-1][j]});
                }
                else if(dp[i-1][j]>dp[i][j]+1)
                {
                    dp[i-1][j]=dp[i][j]+1;
                    pq.add(new int[]{i-1,j,dp[i-1][j]});
                }
            }
            if(j+1<n)
            {
                if(arr[i][j]==1 && dp[i][j+1]>dp[i][j])
                {
                    dp[i][j+1]=dp[i][j];
                    pq.add(new int[]{i,j+1,dp[i][j+1]});
                }
                else if(dp[i][j+1]>dp[i][j]+1)
                {
                    dp[i][j+1]=dp[i][j]+1;
                    pq.add(new int[]{i,j+1,dp[i][j+1]});
                }
            }
            if(j-1>=0)
            {
                if(arr[i][j]==2 && dp[i][j-1]>dp[i][j])
                {
                    dp[i][j-1]=dp[i][j];
                    pq.add(new int[]{i,j-1,dp[i][j-1]});
                }
                else if(dp[i][j-1]>dp[i][j]+1)
                {
                    dp[i][j-1]=dp[i][j]+1;
                    pq.add(new int[]{i,j-1,dp[i][j-1]});
                }
            }
        }
        return dp[m-1][n-1];
    }
}