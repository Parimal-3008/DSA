class Solution {
    public int minInsertions(String str) {
        String rev ="";
      for(int i=str.length()-1;i>=0;i--)
        rev = rev + String.valueOf(str.charAt(i));
      int dp[][]= new int[str.length()][rev.length()];
     // System.out.println(str+" "+rev);
      for(int i[]:dp)
        Arrays.fill(i,-1);
      int ans = call(str,rev,0,0,dp);
    //  System.out.println(ans);
      return str.length()-ans;
    }
  public int call(String str1, String str2, int i, int j,int[][] dp)
  {
    if(i==str1.length()||j==str2.length())
      return 0;
    if(dp[i][j]!=-1)
      return dp[i][j];
    char ch1 = str1.charAt(i);
    char ch2 = str2.charAt(j);
    if(ch1 == ch2)
      return dp[i][j]= 1 + call(str1,str2,i+1,j+1,dp);
    int a = call(str1,str2,i+1,j,dp);
    int b = call(str1,str2,i,j+1,dp);
    return dp[i][j]=Math.max(a,b);
  }
}