class Solution {
    public int minSubArrayLen(int k, int[] arr) {
          int max = 10000000;
      int l = 0;
     
      int sum =0;
      for(int i=0;i<arr.length;i++)
      {
        sum+=arr[i];
        // if(sum>=k)
        while(sum>=k && l<=i)
        {
           if(sum>=k)
          max = Math.min(max,i-l+1);
          sum-=arr[l];
           if(sum>=k)
          max = Math.min(max,i-l);
         
          l++;
        }
      }
      if(max == 10000000)
        max = 0;
      return max;
    }
}