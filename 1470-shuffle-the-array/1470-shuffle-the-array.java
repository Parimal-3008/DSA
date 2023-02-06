class Solution {
    public int[] shuffle(int[] arr, int n) {
        int arr2[]=  new int[n+n];
      int i=0;int j = n;
      int k =0;
      while(i<n)
      {
        arr2[k]=arr[i];
        k++;
        arr2[k]=arr[j];
        k++;
        i++;j++;
      }
      return arr2;
    }
}