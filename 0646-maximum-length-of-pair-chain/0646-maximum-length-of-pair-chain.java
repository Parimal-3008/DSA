class Solution {
    public int findLongestChain(int[][] arr) {
        Arrays.sort(arr,new Comparator<int[]>(){
           @Override
            public int compare(int[] o1,int[] o2)
            {
                int result = Integer.compare(o1[0], o2[0]);
                if (result == 0) 
                    result = Integer.compare(o1[1], o2[1]);    
                return result;
                    
            }
        });
        int dp[][] = new int[arr.length+1][10000];
        for(int i=0;i<dp.length;i++)
             Arrays.fill(dp[i],-1);
        // for(int i[]:arr)
        //     System.out.print("["+i[0]+","+i[1]+"]"+"..");
        return call(0,arr,-1001,dp);
    }
    public int call(int i,int[][] arr,int prev,int[][] dp)
    {
        if(i==arr.length)
        {
            return 0;
        }
        if(dp[i][prev+1001]!=-1)
            return dp[i][prev+1001];
        int a =Integer.MIN_VALUE;
        if(arr[i][0]>prev)
        {
            a = 1 + call(i+1,arr,arr[i][1],dp);
        }
        int b = call(i+1,arr,prev,dp);
        return dp[i][prev+1001] = Math.max(a,b);
        
        
    }
    
}