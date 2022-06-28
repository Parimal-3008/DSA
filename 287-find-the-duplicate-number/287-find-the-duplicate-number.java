class Solution {
    public int findDuplicate(int[] arr) {
    int  i= 0;int n = arr.length;
      int j =0;
       do  
        {
        i=arr[i];
        j=arr[arr[j]];
      
       }while(arr[i]!=arr[j]);
      i=0;
      while(arr[i]!=arr[j]){
        i = arr[i];
        j= arr[j];
      }
      return arr[i];
    }
};