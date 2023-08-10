class Solution {
    public int numDecodings(String str) {
        char[] arr= str.toCharArray();
        int[][] dp= new int[arr.length+1][arr.length+1];
        for(int i[]:dp)
            Arrays.fill(i,-1);
        return call(0,0,dp,str);
    }
    public int call(int i, int prev, int[][] dp,String str)
    {
       if(i-prev>=3)
           return 0;
        if(i<str.length() && prev == i && str.charAt(i)=='0')
            return 0;
       if(i==str.length()-1)
       {
    if(Integer.parseInt(str.substring(prev,i+1))<=26 &&Integer.parseInt(str.substring(prev,i+1))>0)
                return 1;
           return 0;
       }
        
        if(dp[i][prev]!=-1)
            return dp[i][prev];
        int a = 0;int b = 0;
if(Integer.parseInt(str.substring(prev,i+1))<=26 &&Integer.parseInt(str.substring(prev,i+1))>0)
      a = call(i+1,i+1,dp,str);
        b = call(i+1,prev,dp,str);
        return dp[i][prev]=a+b;
    }
}