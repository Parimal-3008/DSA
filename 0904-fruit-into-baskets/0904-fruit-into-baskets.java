class Solution {
    public int totalFruit(int[] arr) {
        int l =1;int r = arr.length;
      if(r<=2)
        return r;
      int ans = 2;
      while(l<=r)
      {
        int mid = (l+r)/2;
        if(ispossible(arr,mid))
        {
          ans = mid;
          l = mid+1;
        }
        else
          r = mid-1;
      }
      return ans;
    }
  public boolean ispossible(int[] arr, int mid)
  {
    Map<Integer,Integer> mp = new HashMap<>();
    for(int i=0;i<mid;i++)
      mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
    if(mp.size()<=2)
      return true;
    for(int i=mid;i<arr.length;i++)
    {
      mp.put(arr[i-mid],mp.get(arr[i-mid])-1);
      if(mp.get(arr[i-mid])==0)
        mp.remove(arr[i-mid]);
      mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
      if(mp.size()<=2)
        return true;
      
    }
    return false;
  }
}