class Solution {
    public int minCapability(int[] arr, int k) {
        int l = 1;
      int r = 1;
      int ans =1;
      for(int i:arr)
        r = Math.max(i,r);
      while(l<=r)
      {
        int mid= (l+r)/2;
        if(check(mid,arr,k))
        {
          ans=mid;
          r = mid-1;
        }
        else
          l = mid+1;
      }
      return ans;
    }
  public boolean check(int mid, int[] arr, int k)
  {
    int prev = -1;
    int curr = 0;
    for(int i=0;i<arr.length;i++)
    {
       if(arr[i]>mid)
          continue;
        i++; 
        curr++;
       
     }
    return curr>=k;
  }
}