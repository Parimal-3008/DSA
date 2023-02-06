class Solution {
    public int maxValue(int n, int index, int k) {
       
      long ans = 1;
      long l = 1;
      long r = (long)k;
      index++;
      while(l<=r)
      {
        long mid = (l+r)/2;
        if(ispossible(mid,n,index,k))
        {
          ans = mid;
          l = mid+1;
        }
        else
          r= mid-1;
      }
      return (int)ans;
    }
  public boolean ispossible(long mid,int n, int index, int k)
  {
    long sum1 = 0;long sum2 =0;
   long p = Math.min(n-index,mid-1);
    sum1 = (p*(mid-1+mid-1+1-p))/2;
    sum1+=Math.max(0,n-index-mid+1);
    p = Math.min(index,mid);
    sum2 = (p*(mid+mid+1-p))/2;
    sum2+=Math.max(0,index-mid);
    // System.out.println(mid+":"+sum1+","+sum2);
    return sum1+sum2<=(long)k;
  }
}