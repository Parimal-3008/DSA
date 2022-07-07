class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
      int dp[][]= new int[105][105];
      if(s3.length()!=s1.length()+s2.length())
        return false;
      for(int i[]:dp)
        Arrays.fill(i,-1);
      int p= call(0,0,0,s1,s2,s3,dp);
      if(p==1)
        return true;
      return false;
        
    }
  public int call(int i, int j, int k, String str1, String str2, String str3,int[][] dp)
  {
   if(i>=str1.length() &&j>=str2.length()&& k>=str3.length())
     return 1;
    if(i<str1.length() && j<str2.length() && dp[i][j]!=-1)
      return dp[i][j];
    if((i<str1.length()&& str1.charAt(i)==str3.charAt(k)) &&(j<str2.length() && str3.charAt(k)==str2.charAt(j)))
        return dp[i][j]= (call(i+1,j,k+1,str1,str2,str3,dp) | call(i,j+1,k+1,str1,str2,str3,dp)) ;
   else if(i<str1.length()&& str1.charAt(i)==str3.charAt(k))
       return dp[i][j]=call(i+1,j,k+1,str1,str2,str3,dp);
   else if(j<str2.length() && str2.charAt(j)==str3.charAt(k))
       return dp[i][j]=call(i,j+1,k+1,str1,str2,str3,dp);
    return dp[i][j]=0;   
  }
}