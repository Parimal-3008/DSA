class Solution {
    public int maximumTastiness(int[] arr, int k) {
        Arrays.sort(arr);
       TreeSet<Integer> set = new TreeSet<>();
      for(int i:arr)
        set.add(i);
      int l = 0;
      int r = arr[arr.length-1]-arr[0];
      int ans = 0;
      while(l<=r)
      {
        int mid = (l+r)/2;
        if(ispossible(mid,set,k))
        {
          ans = mid;
          l = mid+1;
        }
        else
          r = mid-1;
      }
      return ans;
    }
   public boolean ispossible(int mid, TreeSet<Integer> set, int k)
   {
     int prev = set.first();k--;
     while(true && k-->0)
     {
       Integer p = set.ceiling(prev+mid);
       if(p==null)
         return false;
       prev = p;
     }
     return true;
     
   }
}