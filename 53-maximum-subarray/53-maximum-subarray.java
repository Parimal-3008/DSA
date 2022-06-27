class Solution {
    public int maxSubArray(int[] arr) {
        int max =0;
      int ans=Integer.MIN_VALUE;
      for(int i=0;i<arr.length;i++)
      {
        max +=arr[i];
        if(max>ans)
        {
          ans =max;
        }
        if(max<0)
          max=0;
      }
return ans;
    }
}