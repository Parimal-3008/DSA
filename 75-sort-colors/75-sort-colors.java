class Solution {
    public void sortColors(int[] arr) {
        int i=0;
      int j = arr.length-1;
      for(int k=i;k<=j;k++)
      {
        if(arr[k]==0)
        {
          swap(k,i,arr);
          i++;
        }
         else if(arr[k]==2)
        {
          swap(k,j,arr);
          j--;k--;
        }
        if(i>=j)
          break;
      }      
    }
  public void swap (int i, int j, int[] arr)
  {
    int temp = arr[i];
    arr[i]=arr[j];
    arr[j]=temp;
  }
}