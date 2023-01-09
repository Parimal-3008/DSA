class Solution {
    public int numberOfBoomerangs(int[][] arr) {
        int ans =0;
      for(int i=0;i<arr.length;i++)
      {
        Map<Double,Integer> mp = new HashMap<>();
        for(int j=0;j<arr.length;j++)
        {
          if(j==i)
            continue;
          double d1 = Math.pow(arr[i][1]-arr[j][1],2)+Math.pow(arr[i][0]-arr[j][0],2);
          if(mp.containsKey(d1))
            mp.put(d1,mp.get(d1)+1);
          else
            mp.put(d1,1);

          
        }
        // System.out.println(mp);
        for(Map.Entry<Double,Integer> entry:mp.entrySet())
        {
          int n = entry.getValue();
          if(n!=1)
          ans += n*(n-1);
        }
      }
      return ans;
    }
}