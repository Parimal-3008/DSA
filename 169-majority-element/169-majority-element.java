class Solution {
    public int majorityElement(int[] arr) {
        int count=01;
      int elem=arr[0];
      for(int i=1;i<arr.length;i++)
      {
        if(arr[i]==elem)
          count++;
        else
          count--;
        if(count==0)
        {
          count=1;
          elem=arr[i];
        }
      }
      return elem;
    }
}