import java.math.BigInteger;
class Solution {
   long mod= 1000000007;
  public  long power(long x, long n) {
        if (n == 0) {
            return 1l;
        }
        long pow = power(x, n / 2) % mod;
        if ((n & 1) == 1) // if `y` is odd
        {
            return (long)((((x % mod) * (pow % mod)) % mod) * (pow % mod)) % mod;
        }
        // otherwise, `y` is even
        return (long) ((pow % mod) * (pow % mod)) % mod;
    }
    public int countAnagrams(String str) {
        String[] arr = str.split("\\s+");
      int len[] = new int[arr.length];
      for(int i=0;i<arr.length;i++)
      {
        len[i]=arr[i].length();
        
      }
      long dp[]= new long[100009];
      Arrays.fill(dp,-1);
      dp[0]=1;dp[1]=1;
     
      long ans =1;
      int freq[][]= new int[arr.length][26];
      for(int i=0;i<arr.length;i++)
      {
        for(int j=0;j<len[i];j++)
        {
          freq[i][arr[i].charAt(j)-97]++;
        }
        long ans1 = factorial2(len[i],dp);
        for(int j=0;j<26;j++)
        {
          
          ans1= ((ans1%mod)*(power(factorial2(freq[i][j],dp), mod-2)%mod))%mod;
        }
        System.out.println(ans1);
        ans = ans* ans1 % mod;
       
      }
            return (int)(ans%mod);
    }
  public long factorial2(int p, long[] dp)
  {
    if(p==2)
      return 2;
     if(dp[p]!=-1)
       return dp[p];
     return dp[p]= p * factorial2(p-1,dp) % mod;
   
   
   
  }
 
}