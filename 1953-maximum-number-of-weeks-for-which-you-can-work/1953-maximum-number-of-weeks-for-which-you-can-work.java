class Solution {
    public long numberOfWeeks(int[] arr) {
      
      if(arr.length==1)
        return 1l;
      Arrays.sort(arr);
      long ans =0;
      for(int i=0;i<arr.length;i++)
      {        
        if(i==arr.length-1)
        {
          if(ans+1>=arr[i])
            ans+=arr[i];
          else
            ans= ans+ ans+1;
        }
        else
          ans+=arr[i];
      }
      return ans;
    }
}