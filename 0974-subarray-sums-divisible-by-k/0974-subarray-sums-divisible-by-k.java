class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
      int pre[]= new int[arr.length];
      pre[0]=arr[0];
      for(int i=01;i<arr.length;i++)
      {
         pre[i]=arr[i]+pre[i-1];
      }
      int ans =0;
      for(int i=0;i<arr.length;i++)
      {
        System.out.print(pre[i]%k+" ");
        int rem = (pre[i]%k);
        if(rem<0)
          rem+=k;
        if(mp.containsKey(rem))
        {
          int o = mp.get(rem);
          ans+=o;
          mp.put(rem,o+1);
        }
        else
          mp.put(rem,1);
      }
      return mp.containsKey(0)?ans+mp.get(0):ans;
    }
}