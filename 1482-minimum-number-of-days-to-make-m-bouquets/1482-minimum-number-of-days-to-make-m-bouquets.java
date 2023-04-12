class Solution {
    public int minDays(int[] arr, int m, int k) {
        int ans = -1;
      int l = 1;
      int r = 1;
      for(int i:arr)
      {
        r= Math.max(r,i);
        l = Math.min(l,i);
      }
      ans= r;
      while(l<=r)
      {
        int mid= (l+r)/2;
        if(check(arr,mid,m,k))
        {
          ans = mid;
          r= mid-1;
        }
        else
          l= mid+1;
      }
      if(!check(arr,ans,m,k))
        return -1;
      return ans;
    }
    public boolean check(int[] arr, int mid, int m, int k)
    {
      int count1 = 0;
      int count2 = 0;
      
      for(int i=0;i<arr.length;i++)
      {
        if(arr[i]<=mid)
        {
          count1++;
        }
        else
        {
          count1=0;
        }
        if(count1==k)
        {
          count1=0;
          count2++;
        }
      }
      // System.out.println(mid);
      return count2>=m;
    }
}