class Solution {
    public int maxScoreSightseeingPair(int[] arr) {
      int n = arr.length;
      int arr1[]= new int[n];
      int arr2[]= new int[n];
      int max = -1;int ind =-1;
      for(int i=0;i<n;i++)
      {
        arr1[i]=arr[i]+i;
        arr2[i]=arr[i]-i;
       
      }
    int arr3[]= new int[n];
      arr3[n-1]=arr2[n-1];
      for(int i=n-2;i>=0;i--)
      {
        arr3[i]= Math.max(arr3[i+1],arr2[i]);
      }
       // max  = -1;
      for(int i=0;i<n-1;i++)
      {
        max = Math.max(max,arr1[i]+arr3[i+1]);
      }
      return max;
    }
}