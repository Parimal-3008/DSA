class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        int dp[] = new int[150];
        Arrays.fill(dp,-1);
        return call(0,s,dp);
    }
    public int call(int i,String str,int[] dp)
    {
        if(i==str.length())
            return 1;
        int a=0;
        int b=0;
        if(str.charAt(i)=='0')
            return 0;
        if(dp[i]!=-1)
            return dp[i];
        if(i+1<str.length()&&str.charAt(i)!=0&&Integer.parseInt(str.substring(i,i+2))<=26)
            a= call(i+2,str,dp);
        if(str.charAt(i)!=0)
        b= call(i+1,str,dp);
        return dp[i]= a+b;
    }
}