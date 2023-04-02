class Solution {
    public long countGood(int[] arr, int k) {
        long ans = 0;
      Map<Integer,Integer> mp = new HashMap<>();
      int curr =0;int  l = 0;
      for(int i=0;i<arr.length;i++)
      {
        if(mp.containsKey(arr[i]))
        {
          curr+=mp.get(arr[i]);
          mp.put(arr[i],mp.get(arr[i])+1);
        }
        else
          mp.put(arr[i],1);
        while(curr>=k&& l<=i)
        {
          ans+=(long)(arr.length-i);
          int a = mp.get(arr[l]);
         curr-=(a-1);
          mp.put(arr[l],a-1);
          if(a-1==0)
            mp.remove(arr[l]);
          l++;
        }
      }
      return ans;
    }
}