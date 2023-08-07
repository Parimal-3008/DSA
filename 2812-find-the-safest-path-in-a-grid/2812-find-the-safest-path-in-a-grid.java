class Solution {
     int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int maximumSafenessFactor(List<List<Integer>> list) {
        int m = list.size();
        int n = m;
        List<List<Integer>> li = new ArrayList<>();
        int[][] arr= new int[m][n];
        int[][] dp= new int[m][n];
        for(int i[]:dp)
            Arrays.fill(i,Integer.MAX_VALUE);
          Queue<int[]> q = new LinkedList<>();
      
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++){
                arr[i][j]=list.get(i).get(j);     
                if(arr[i][j]==1)
                   {
                    dp[i][j]=0;
                     int[] temp={i,j};
                    q.add(temp);
                    }
            }
        }
        while(!q.isEmpty())
        {
            int[] temp = q.poll();
            int i=temp[0];int j=temp[1];
            if(i+1<m&& dp[i+1][j]>dp[i][j]+1)
            {
                dp[i+1][j]=dp[i][j]+1;
                int temp2[]={i+1,j};
                q.add(temp2);
            }
            if(j+1<n&& dp[i][j+1]>dp[i][j]+1)
            {
                dp[i][j+1]=dp[i][j]+1;
                 int temp2[]={i,j+1};
                q.add(temp2);
            }
            if(i-1>=0&& dp[i-1][j]>dp[i][j]+1)
            {
                dp[i-1][j]=dp[i][j]+1;
                 int temp2[]={i-1,j};
                q.add(temp2);
            }
            if(j-1>=0&& dp[i][j-1]>dp[i][j]+1)
            {
                dp[i][j-1]=dp[i][j]+1;
                 int temp2[]={i,j-1};
                q.add(temp2);
            }                
        }       
         int[][] dp2=new int[arr.length][arr.length];
        for(int i[]:dp2)
            Arrays.fill(i,0);
        // for(int i[]:dp)
        // {
        //     for(int j:i)
        //         System.out.print(j+" ");
        //     System.out.println();
        // }
        // return 10;
      PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[2] - x[2]);
       boolean[][] visited = new boolean[n][n];

        pq.offer(new int[]{0, 0, dp[0][0]});
        visited[0][0] = true;

        while(!pq.isEmpty()) {
            int size = pq.size();

            for(int i=0; i<size; i++) {
                int[] p = pq.poll();

                if(p[0] == n-1 && p[1] == n-1) return p[2];

                for(int j=0; j<4; j++) {
                    int x = dirs[j][0] + p[0];
                    int y = dirs[j][1] + p[1];


                    if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        pq.offer(new int[]{x, y, Math.min(p[2], dp[x][y])});
                    }
                }
            }
        }

        return 0;
      }
     
}