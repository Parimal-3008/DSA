class Solution {
    public int minimumEffort(int[][] arr) {
      Arrays.sort(arr,new Comparator<int[]>(){
        public int compare(int[]a, int[] b)
        {
          int res = Integer.compare(b[1]-b[0],a[1]-a[0]);
          if(res == 0)
            res = Integer.compare(b[1],a[1]);
        //  if(res==0)
           // res = Integer.compare();
          return res;
        }
      });
      int ans = arr[0][1];
      int curr = arr[0][1]-arr[0][0];
      for(int i=1;i<arr.length;i++)
      {
          if(curr<arr[i][1])
          {
            ans+=arr[i][1]-curr;
            curr=arr[i][1]-arr[i][0];
          }
        else
        {
          curr-=arr[i][0];
        }
      }
      return ans;
      
        
    }
}