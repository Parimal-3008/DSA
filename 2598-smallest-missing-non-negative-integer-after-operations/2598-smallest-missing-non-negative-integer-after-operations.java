class Solution {
    public int findSmallestInteger(int[] arr, int k) {
      Arrays.sort(arr);
      Map<Integer,Integer> mp = new HashMap<>();
      for(int i=0;i<arr.length;i++)
      {
        int rem = arr[i]%k;
        if(rem<0)
          rem+=k;
        if(mp.containsKey(rem))
          mp.put(rem,mp.get(rem)+1);
        else
          mp.put(rem,1);
      }
      Set<Integer> set = new HashSet<>();
      for(Map.Entry<Integer,Integer> entry:mp.entrySet())
      {
        int rem = entry.getKey();
        int val = entry.getValue();
        set.add(rem);
        for(int j=1;j<val;j++)
        {
          set.add(rem+(k*j));
        }
      }
      // System.out.println(mp+" "+set);
      for(int i=0;i<arr.length;i++)
      {
        if(!set.contains(i))
          return i;
      }
      return arr.length;
        
    }
}