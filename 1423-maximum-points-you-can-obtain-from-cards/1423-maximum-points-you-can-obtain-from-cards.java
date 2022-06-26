class Solution {
    public int maxScore(int[] arr, int k) {
        int max=0;
      int curr=0;
      for(int i=0;i<k;i++)
        max+=arr[i];
      
      for(int i =arr.length-k;i<arr.length;i++)
      {
        curr+=arr[i];
        max=Math.max(max,curr);
         //System.out.println(curr);
      }
      for(int i=arr.length-k+1;i<arr.length;i++)
      {
          curr-=arr[i-1];
        curr+=arr[(i+k-1)%arr.length];
       // System.out.println(curr);
        max=Math.max(max,curr);
      }
      return max;
    }
}