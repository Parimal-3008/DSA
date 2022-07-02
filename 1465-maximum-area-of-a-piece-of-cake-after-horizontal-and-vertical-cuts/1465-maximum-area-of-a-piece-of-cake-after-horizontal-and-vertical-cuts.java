class Solution {
    public int maxArea(int h, int w, int[] harr, int[] varr) {
        Arrays.sort(harr);
        Arrays.sort(varr);
        int max1=harr[0];int max2 = varr[0];      
      for(int i=0;i<harr.length-1;i++)
      {
        max1 = Math.max(max1,harr[i+1]-harr[i]);
      }
      max1 = Math.max(max1,h-harr[harr.length-1]);
         for(int i=0;i<varr.length-1;i++)
      {
        max2 = Math.max(max2,varr[i+1]-varr[i]);
      }
     max2 = Math.max(max2,w-varr[varr.length-1]);
           System.out.println(max1+" "+max2);
      //long mod = 1000_1000_007;
      return (int)((long)max1 * max2 % 1000000007);
    }
}