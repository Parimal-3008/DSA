class Solution {
    public int minInsertions(String str) {
        String str2= "";
        for(int i=str.length()-1;i>=0;i--)
            str2=str2+String.valueOf(str.charAt(i));
        int[][] dp = new int[str.length()][str.length()];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        int a = call(str,str2,0,0,dp);
        return str.length()-a;
    }
    public int call(String str1,String str2,int i, int j, int[][] dp)
    {
        if(i==str1.length() || j== str2.length())
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int a= 0;int b = 0;int c = 0;
        if(str1.charAt(i)==str2.charAt(j))
        {
            a = 1 + call(str1,str2,i+1,j+1,dp);            
        }
        b = call(str1,str2,i+1,j,dp);
        c = call(str1,str2,i,j+1,dp);
        return dp[i][j]=Math.max(a,Math.max(b,c));
    }
}