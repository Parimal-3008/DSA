class Solution {
    public int[] pivotArray(int[] arr, int x) {
        int ans[]= new int[arr.length];int j=0;
       for(int i=0;i<arr.length;i++)
       {
         if(arr[i]<x){
           ans[j]=arr[i];j++;}
       }
      for(int i=0;i<arr.length;i++)
       {
         if(arr[i]==x){
           ans[j]=arr[i];j++;}
       }
      for(int i=0;i<arr.length;i++)
       {
         if(arr[i]>x){
           ans[j]=arr[i];j++;}
       }
      return ans;
    }
}