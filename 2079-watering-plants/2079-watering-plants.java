class Solution {
    public int wateringPlants(int[] arr, int k) {
      int ans =0;
      int curr = k;
      for(int i=0;i<arr.length;i++)
      {
        if(curr>=arr[i])
        {
          ans++;
          curr-=arr[i];
        }
        else
        {
          ans+=(i+i+1);
          curr=k;
          curr-=arr[i];
          
        }
      }
      return ans;
        
    }
}