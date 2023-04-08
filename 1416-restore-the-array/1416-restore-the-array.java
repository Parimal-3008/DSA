class Solution {
  long mod = 1000000007;
    public int numberOfArrays(String str, int k) {
      long dp[]= new long[str.length()];
      Arrays.fill(dp,-1);
        return (int)call(0,str,k,dp);
    }
  public long call(int i,String str, int k,long[] dp)
  {
    if(i == str.length())
      return 1;
    long ans = 0;
    long a = 0;
    if(dp[i]!=-1)
      return dp[i];
    for(int j=i;ans<=k && j<str.length();j++)
    {
      char ch = str.charAt(j);
      int p = Integer.parseInt(String.valueOf(ch));
      ans = (ans * 10) + p;
      if(ans==0)
        break;
      if(ans>k)
      {
       return dp[i]=a;
      }
      else
      {
        // System.out.println(ans);
        a =( (a % mod) + call(j+1,str,k,dp)%mod) % mod;
        while(a<0)
          a+=mod;
      }      
    }
    return dp[i]= a;    
  }
}