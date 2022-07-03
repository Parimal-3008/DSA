class Solution {
    public int peopleAwareOfSecret(int n, int d, int f) {
        long arr[] = new long[1005];
        
        arr[1]=1;//arr[1+d]=2;
      for(int i=1;i<=n;i++)
      {
        int k=i+d;
          for(int j=f-d;j>0;j--)
          {
            if(k>n+1)
              break;
              arr[k]=(arr[k]+arr[i])%1000000007;
               k++;
            
          }
        // if(i-d-1>=0)
        //   arr[i-d-1]--;
      }
      long ans=0;
      for(int i=n;i>=n+1-f;i--)
      {
        //System.out.print(arr[i]+",");
        if(arr[i]>=0)
          ans=(ans+arr[i])%1000000007;
      }
      long res=0;
      // for(int i=n;i>=0;i--)
      //   System.out.print(((res+=arr[i])%1000000007)+",");
     // System.out.println(ans);
        return (int)ans%1000000007;
    }
}