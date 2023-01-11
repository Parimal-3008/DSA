class Solution {
    public int countNicePairs(int[] arr) {
      long ans =0;
      int mod = 1000000007;
        Map<Integer,Integer> mp = new HashMap<>();
      for(int i=0;i<arr.length;i++)
      {
        int p = arr[i];int p2 =0;
        while(p>0)
        {
          p2 = p2*10 +(p%10);
          p/=10;
        }
        if(mp.containsKey(arr[i]-p2))
        {
          ans= (ans + mp.get(arr[i]-p2))%mod;
          mp.put(arr[i]-p2,mp.get(arr[i]-p2)+1);
        }
        else
          mp.put(arr[i]-p2,1);
      }
      return (int)ans%mod;
    }
}