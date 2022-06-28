class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int i =arr1.length-1;m--;n--;
        while(m>=0&& n>=0)
        {
          if(arr1[m]>arr2[n])
          {
            arr1[i]=arr1[m];
            m--;
          }
          else
           {
            arr1[i]=arr2[n];
            n--;
           }
          i--;
        }
      while(m>=0)
      {
         arr1[i]=arr1[m];
            m--;i--;
      }
      while(n>=0)
      {
         arr1[i]=arr2[n];
            n--;i--;
      }
      
    }
}