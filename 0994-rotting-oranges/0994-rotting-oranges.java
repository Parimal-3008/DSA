class Solution {
    public int orangesRotting(int[][] arr) {
        int[][] dp= new int[arr.length][arr[0].length];
        for(int i[]:dp)
            Arrays.fill(i,50000);
        Queue<int[]> pq = new LinkedList<>();
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==2){
                    dp[i][j]=0;
                    int temp[]= {i,j};
                  pq.add(temp);
                }
                // if(arr[i][j]==1)
                //     dp[i][j]=
            }
        }
        int m = arr.length;int n= arr[0].length;
        while(!pq.isEmpty())
        {
            int[] temp2 = pq.poll();int i=temp2[0];int j=temp2[1];
            // System.out.println(i+" "+j);
            if(i+1<m && dp[i+1][j]>dp[i][j]+1 && arr[i+1][j]==1)
            {
               dp[i+1][j]=dp[i][j]+1;
                int[] temp={i+1,j};
                pq.add(temp);
            }
            if(i-1>=0 && dp[i-1][j]>dp[i][j]+1&& arr[i-1][j]==1)
            {
               dp[i-1][j]=dp[i][j]+1;
                int[] temp={i-1,j};
                pq.add(temp);
            }
            if(j+1<n && dp[i][j+1]>dp[i][j]+1 && arr[i][j+1]==1)
            {
               dp[i][j+1]=dp[i][j]+1;
                int[] temp={i,j+1};
                pq.add(temp);
            }
            if(j-1>=0 && dp[i][j-1]>dp[i][j]+1 && arr[i][j-1]==1)
            {
               dp[i][j-1]=dp[i][j]+1;
                int[] temp={i,j-1};
                pq.add(temp);
            }
        }
        int ans = 0;
       for(int i=0;i<m;i++)
       {
           for(int j=0;j<n;j++)
           {
               // System.out.print(dp[i][j]+" ");
               if(arr[i][j]==1)
                   ans = Math.max(ans,dp[i][j]);
           }
           // System.out.println();
       }
        if(ans == 50000)
            return -1;
        return ans;
    }
}