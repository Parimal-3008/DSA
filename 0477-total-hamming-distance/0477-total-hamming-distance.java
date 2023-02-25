class Solution {
    public int totalHammingDistance(int[] arr2) {
      int arr[]= new int[32];
      int n = arr2.length;
        for(int i=0;i<arr2.length;i++)
        {
          String str= Integer.toBinaryString(arr2[i]);
          int p=31;
          for(int j=str.length()-1;j>=0;j--)
          {
            if(str.charAt(j)=='1')
              arr[p]++;
            p--;
          }
        }
      int ans =0;
      
      for(int i:arr)
      {
           int temp = (n-i)*i;
        ans+=temp;
      }
      return ans;
    }
}