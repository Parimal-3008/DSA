class Solution {
    public int numDistinct(String s, String t) {
      int dp[][]= new int[s.length()+1][t.length()+1];
      for(int i[]:dp)
        Arrays.fill(i,-1);
        return call(0,0,s,t,dp);
    }
  public int call(int i, int j, String s, String t,int[][] dp)
  {
    if( j== t.length())
      return 1;
    if(i==s.length())
      return 0;
    if(dp[i][j]!=-1)
      return dp[i][j];
    if(s.charAt(i)==t.charAt(j))
    {
      return dp[i][j]= call(i+1,j+1,s,t,dp)+call(i+1,j,s,t,dp);
      
    }
    else
      return dp[i][j]=call(i+1,j,s,t,dp);
  }
}