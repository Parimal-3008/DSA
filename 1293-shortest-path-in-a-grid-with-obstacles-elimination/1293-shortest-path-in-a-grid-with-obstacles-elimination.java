class Solution {
    public int shortestPath(int[][] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
       
        int m = arr.length;int n = arr[0].length;
        int[][][] dp = new int[m][n][k+1];
        for(int[][] i:dp)
            for(int[] j: i)
                Arrays.fill(j,Integer.MAX_VALUE);
        dp[0][0][k]=0;
        pq.add(new int[]{0,0,0,arr[0][0]==0?k:k-1});
        while(!pq.isEmpty())
        {
            int temp[]= pq.poll();
            int i=temp[0];int j=temp[1];int k1=temp[2];int k3=temp[3];
            if(i==m-1 && j==n-1)
                return dp[i][j][k3];
            // System.out.println(i+" "+j+" "+k1+" "+k3);
            if(i+1<m && dp[i+1][j][k3]==Integer.MAX_VALUE)
            {
                dp[i+1][j][k3]=k1+1;
                if(arr[i+1][j]==0)
                    pq.add(new int[]{i+1,j,k1+1,k3});
                else if(k3>0)
                    pq.add(new int[]{i+1,j,k1+1,k3-1});
            }
             if(i-1>=0 && dp[i-1][j][k3]==Integer.MAX_VALUE)
            {
                dp[i-1][j][k3]=k1+1;
                if(arr[i-1][j]==0)
                    pq.add(new int[]{i-1,j,k1+1,k3});
                else if(k3>0)
                    pq.add(new int[]{i-1,j,k1+1,k3-1});
            }
              if(j+1<n && dp[i][j+1][k3]==Integer.MAX_VALUE)
            {
                dp[i][j+1][k3]=k1+1;
                if(arr[i][j+1]==0)
                    pq.add(new int[]{i,j+1,k1+1,k3});
                else if(k3>0)
                    pq.add(new int[]{i,j+1,k1+1,k3-1});
            }
             if(j-1>=0 && dp[i][j-1][k3]==Integer.MAX_VALUE)
            {
                dp[i][j-1][k3]=k1+1;
                if(arr[i][j-1]==0)
                    pq.add(new int[]{i,j-1,k1+1,k3});
                else if(k3>0)
                    pq.add(new int[]{i,j-1,k1+1,k3-1});
            }
            
        }
        return -1;
   
       
    }
}