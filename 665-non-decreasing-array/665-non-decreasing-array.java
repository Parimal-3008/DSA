class Solution {
    public boolean checkPossibility(int[] arr) {
        int count=0;int ind=-1;
      int[] arr1= new int[arr.length];
      int[] arr2= new int[arr.length];
      for(int i=0;i<arr.length;i++)
      {
        arr1[i]=arr[i];
        arr2[i]=arr[i];
      }
      for(int i=0;i<arr.length-1;i++)
      {
        if(arr[i]>arr[i+1])
         {
         arr2[i]=arr2[i+1];
          arr1[i+1]=arr1[i];
          break;
         }
      }
     for(int i=0;i<arr.length-1;i++)
      {
        if(arr2[i]>arr2[i+1])
         {
         count++;
         }
      }
      if(count==0)
      return true;
      count=0;
      for(int i=0;i<arr.length-1;i++)
      {
        if(arr1[i]>arr1[i+1])
         {
         count++;
         }
      }
      if(count==0)
      return true;
      return false;
    }
}