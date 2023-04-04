class Solution {
    public List<Long> minOperations(int[] arr, int[] queries) {
        long pre[]= new long[arr.length];
      Arrays.sort(arr);
      pre[0]=arr[0];
      for(int i=1;i<arr.length;i++)
      {
        pre[i]=pre[i-1]+arr[i];
      }
      TreeMap<Integer,Integer> mp = new TreeMap<>();
      for(int i=0;i<arr.length;i++)
        mp.put(arr[i],i+1);
      List<Long> ans= new ArrayList<>();
      int n = arr.length;
      // System.out.println(mp+" "+pre[n-1]);
      for(int i:queries)
      {
        Integer p = mp.floorKey(i);
        Integer q = mp.ceilingKey(i);
        long curr=0;
        if(p==null || q== null)
        {
          curr=Math.abs(pre[n-1]-((long)i*(long)n));
          ans.add(curr);
          continue;
        }
        int p1 = mp.get(p);
        long a = Math.abs(((long)i*(long)p1)-pre[p1-1]);
        long b = Math.abs(((long)i*(long)(n-p1))-Math.abs(pre[n-1]-pre[p1-1]));
        // System.out.println(p+" "+p1+" "+a+" "+b);
        curr=a+b;
        ans.add(curr);
      }
      return ans;
      
    }
}