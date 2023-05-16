class Solution {
    public int[] colorTheArray(int n, int[][] arr) {
        int color[]= new int[n];
        int ans[]= new int[arr.length];
      for(int i=0;i<arr.length;i++)
      {
        int a = arr[i][0];
        int b = arr[i][1];
        if(i-1>=0)
        ans[i]=ans[i-1];
        if(color[a]==0)
        {
          color[a]=b;
          if(a-1>=0 && color[a]==color[a-1])
            ans[i]++;
          if(a+1<n && color[a]==color[a+1])
            ans[i]++;
          
        }
        else
        {
          
          if(a-1>=0 && color[a]==color[a-1]&& color[a]!=0)
            ans[i]--;
           if(a+1<n && color[a]==color[a+1] && color[a]!=0)
            ans[i]--;
           color[a]=b;
          if(a-1>=0 && color[a]==color[a-1])
            ans[i]++;
          if(a+1<n && color[a]==color[a+1])
            ans[i]++;
        }
      }
      return ans;
    }
}