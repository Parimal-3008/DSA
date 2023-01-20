class Solution {
    public int waysToSplitArray(int[] arr2) {
      long arr[]= new long[arr2.length];
      arr[0]=arr2[0];
        for(int i=1;i<arr.length;i++)
          arr[i]=arr[i-1]+arr2[i];
      int  n = arr.length;
      int ans =0;
      for(int i=0;i<arr.length-1;i++)
      {
        long p1 = arr[i];long p2 = arr[n-1]-arr[i];
        if(p1>=p2)
          ans++;
      }
      return ans;
    }
}