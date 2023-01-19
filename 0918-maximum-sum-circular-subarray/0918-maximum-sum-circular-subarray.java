class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int max=Integer.MIN_VALUE;int curr=0;
      int tot=0;
      int c=0;int y=max;
      for(int i:arr)
      {
        y = Math.max(y,i);
        if(i<0)
          c++;
      }
      if(c==arr.length)
      {
        return y;
      }
      if(arr.length==1)
        return arr[0];
      for(int i=0;i<arr.length;i++)
      {
        curr+=arr[i];tot+=arr[i];
        max=Math.max(max,curr);
        if(curr<0)
          curr=0;
        // arr[i]*=-1;
      }
      int min_ending_here = 2147483647;
        int min_so_far = 2147483647;
        for (int i = 0; i < arr.length; i++)
        {             
            if (min_ending_here > 0)
                min_ending_here = arr[i];
            else
                min_ending_here += arr[i];
            min_so_far = Math.min(min_so_far,min_ending_here);        
        }        
      // System.out.println(max1);
      return Math.max(max,tot-min_so_far);
    }
}