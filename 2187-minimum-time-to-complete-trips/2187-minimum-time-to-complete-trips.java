class Solution {
    public long minimumTime(int[] arr, int k) {
        Arrays.sort(arr);
      long l = 1;long ans =01;
      long r = (long)arr[0]*(long)k;
      while(l<=r)
      {
        long mid = (l+r)/2;
        if(check(mid,arr,k))
        {
          ans = mid;
          r = mid-1;
        }
        else
          l = mid+1;
      }
      return ans;
    }
  public boolean check(long mid, int[] arr, int k)
  {
    long curr =0;
    for(int i=0;i<arr.length;i++)
      curr= curr + (mid/(long)arr[i]);
    return curr>=k;
  }
}