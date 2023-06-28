class Solution {
        int mod = 1000000007;
    public int knightDialer(int n) {
        List<List<Integer>> list = new ArrayList<>();
        if(n==1)
            return 10;
        for(int i=0;i<=9;i++)
            list.add(new ArrayList<>());
        list.get(0).add(4); list.get(0).add(6);
         list.get(1).add(6); list.get(01).add(8);
         list.get(2).add(7);list.get(2).add(9);
        
         list.get(3).add(8); list.get(03).add(4);
         list.get(4).add(3);list.get(4).add(9);list.get(4).add(0);
        
         list.get(7).add(6); list.get(7).add(2);
         list.get(6).add(0);list.get(6).add(1);list.get(6).add(7);
        
         list.get(8).add(1); list.get(8).add(3);
         list.get(9).add(4);list.get(9).add(2);
        long[][] dp = new long[n][15];
        for(long i[]:dp)
            Arrays.fill(i,-1);
        return (int)call(0,-1,n,list,dp);
        
    }
    public long call(int i, int prev,int n,List<List<Integer>> list,long[][] dp)
    {
        if(i==n-1)
            return list.get(prev).size();
        if(prev == -1)
        {
            long ans = 0;
            for(int j=0;j<10;j++)
            {
                if(j==5)
                    continue;
                ans = (ans%mod + call(i+1,j,n,list,dp)%mod)%mod;
                 // System.out.println(ans);
            }
           
            return ans;
        }
        if(dp[i][prev+1]!=-1)
            return dp[i][prev+1];
        long ans = 0;
        for(int j:list.get(prev))
        {
            long y = call(i+1,j,n,list,dp)%mod;
           
            ans = ((ans%mod) +( y%mod))%mod;
            while(ans<0)
                ans+=mod;
            
        }
        // System.out.println(ans);
        return dp[i][prev+1]=ans;
        
    }
}