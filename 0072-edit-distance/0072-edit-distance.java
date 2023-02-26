class Solution {
    public int minDistance(String str1, String str2) {
       int dp[][]= new int[str1.length()+1][str2.length()+1];
      for(int i[]:dp)
        Arrays.fill(i,-1);
      return call(0,0,str1.toCharArray(),str2.toCharArray(),dp);
    }
  public int call(int i, int j,char[] arr1, char[] arr2, int[][] dp )
  {
    if(i==arr1.length)
      return arr2.length-j;
     if(j==arr2.length)
      return arr1.length-i;
    if(dp[i][j]!=-1)
      return dp[i][j];
     if(arr1[i]==arr2[j])     
       return dp[i][j]=call(i+1,j+1,arr1,arr2,dp);
    int a = 1+ call(i+1,j,arr1,arr2,dp);//delete
    int b = 1+ call(i+1,j+1,arr1,arr2,dp);//replace
    int c = 1+ call(i,j+1,arr1,arr2,dp);//insert
    return dp[i][j]=Math.min(a,Math.min(b,c));
  }
}