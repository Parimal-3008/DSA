class Solution {
    public int minFlipsMonoIncr(String str) {
        int zero[]= new int[str.length()];
        int one[]= new int[str.length()];
      int z=0;int o =0;
      for(int i=str.length()-1;i>=0;i--)
      {
        char ch = str.charAt(i);
        if(ch=='1')
          o++;
        else
          z++;
        zero[i]=z;
        
      }
      z=0;o=0;
      for(int i=0;i<str.length();i++)
      {
        char ch = str.charAt(i);
        if(ch=='1')
          o++;
        else
          z++;
        one[i]=o;
      }
      int max =Math.min(z,o);
      for(int i=0;i<str.length();i++)
      {
        if(i-1>=0)
        max = Math.min(max,zero[i]+one[i-1]);
        
      }
      return max;
    }
}