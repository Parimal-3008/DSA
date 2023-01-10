class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long arr[]= new long[10000];
      long mod = 1000000007;
      arr[1]=1;
      long p =0;
      for(int i=1;i<=n;i++)
      {
        if(arr[i]==0)
          continue;
        for(int j=i+delay;j<i+forget&& j<arr.length;j++)
          arr[j]= (arr[j]+arr[i])%mod;
      }
      for(int i=n-forget+1;i<=n;i++)
        p= (p+ arr[i])%mod;
      return (int)p;
    }
}