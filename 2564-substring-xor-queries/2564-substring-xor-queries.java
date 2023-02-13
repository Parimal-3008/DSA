class Solution {
    public int[][] substringXorQueries(String str, int[][] arr) {
        Map<String,Integer[]> mp = new HashMap<>();
      for(int i=1;i<=31;i++)
      {
        call(i,str,mp);
      }
      int ans[][]= new int[arr.length][2];
      for(int i=0;i<arr.length;i++)
      {
        int ans2 = arr[i][0]^arr[i][1];
        String p = Integer.toBinaryString(ans2);
        if(mp.containsKey(p))
        {
          Integer po[]= mp.get(p);
          ans[i][0]=po[0];
          ans[i][1]=po[1];
        }
        else
        {
          ans[i][0]=-1;
          ans[i][1]=-1;
        }
      }
      return ans;
    }
  public void call(int len,String str,Map<String,Integer[]> mp)
  {
    for(int i=len;i<=str.length();i++)
    {
      String temp= str.substring(i-len,i);
      if(!mp.containsKey(temp))
      {
        Integer[] art= new Integer[2];
        art[0]=i-len;
        art[1]=i-1;
        mp.put(temp,art);
      }
    }
    
  }
}