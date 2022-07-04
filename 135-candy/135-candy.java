class Solution {
    public int candy(int[] arr) {
      int n = arr.length;
      int ans[]= new int[n];
      Arrays.fill(ans,1);
      for(int i=0;i<n-1;i++)
      {
        if(arr[i]<arr[i+1] && ans[i+1]<=ans[i])
          ans[i+1]=ans[i]+1;
        else if(arr[1+i]<arr[i]&& ans[i+1]>=ans[i])
          ans[i]=ans[i+1]+1;
      }
       for(int i=n-2;i>=0;i--)
      {
        if(arr[i]<arr[i+1] && ans[i+1]<=ans[i])
          ans[i+1]=ans[i]+1;
        else if(arr[1+i]<arr[i]&& ans[i+1]>=ans[i])
          ans[i]=ans[i+1]+1;
      }
      int sum=0;
        for(int i:ans)
        {
          System.out.print(i+",");
          sum+=i;
        }
      return sum;
    }
}