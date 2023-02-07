class Solution {
    public int minimizeArrayValue(int[] arr) {
        long r =Integer.MAX_VALUE; long ans =1;
     
      long l = 0;
      while(l<=r)
      {
        long mid = (l+r)/2;
        if(ispossible(mid,arr))
        {
          r  = mid-1;
          ans = mid;
        }
        else
        {
          l = mid+1;
        }
      }
      return (int)ans;
    }
  public boolean ispossible(long mid, int[] arr)
  {
    long temp[]= new long[arr.length];
    for(int i=0;i<arr.length;i++)
      temp[i]=arr[i];
    for(int i=arr.length-1;i>0;i--)
    {
      if(temp[i]>mid)
      {
        long diff = temp[i]-mid;
        temp[i]=mid;
        temp[i-1]+=diff;
      }
    }
    if(temp[0]>mid)
      return false;
    return true;
  }
}