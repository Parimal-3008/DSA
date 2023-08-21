class Solution {
    int[][][] dp = new int[101][101][101];
    int[][] dp2= new int[1][1];
    public int palindromePartition(String str, int k) {
        dp= new int[str.length()+1][str.length()+1][str.length()+1];
        dp2= new int[str.length()+1][str.length()+1];
        for(int i[]:dp2)
            Arrays.fill(i,-1);
       
        for(int i[][]:dp)
            for(int j[]:i)
            Arrays.fill(j,-1);
        return call(str,0,0,k);
    }
    public int call(String str,int i, int start, int k)
    {
        
        if(i>=str.length())
            return Integer.MAX_VALUE-10000;
        if(k==1)
        {
            int p = change(str,i,str.length()-1);
            return p;
        }
        if(dp[i][start][k]!=-1)
            return dp[i][start][k];
        int a = call(str,i+1,start,k);
        int b = change(str,start,i)+ call(str,i+1,i+1,k-1);
        return dp[i][start][k]= Math.min(a,b);
    }
    public int change(String str, int i, int j)
    {
        int ans = 0;
         // System.out.print(i+" "+j+" ");
       if(dp2[i][j]!=-1)
           return dp2[i][j];
        int p = i;int q= j;
        while(i<=j)
        {
            if(str.charAt(i)!=str.charAt(j))
                ans++;
            i++;j--;
        }
        // System.out.print(ans);
        // System.out.println();
        return dp2[p][q]=ans;
    }
}