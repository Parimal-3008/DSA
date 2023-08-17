class Solution {
    public int uniquePathsIII(int[][] arr) {
        int i1=-1;int j1=-1;int i2=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                if(arr[i][j]==1)
                {
                    i1=i;j1=j;
                }
               
                if(arr[i][j]!=-1)
                    i2++;
            }
        }
        // System.out.println(i2);
        return call(i1,j1,1,i2,arr,new boolean[arr.length][arr[0].length]);
        }
    public int call(int i,int j, int k,int k2,int[][] arr,boolean[][] st)
    {
        if(i<0 || j< 0 || i==arr.length || j==arr[0].length)
            return 0;
        if(st[i][j] ||arr[i][j]==-1)
            return 0;
        if(arr[i][j]==2)
        {
            // System.out.println(k+" "+k2);
            if(k==k2)
                return 1;
            return 0;
        }
            
        st[i][j]=true;
        int ans = 0;
        ans += call(i+1,j,k+1,k2,arr,st);
        ans += call(i-1,j,k+1,k2,arr,st);
        ans += call(i,j+1,k+1,k2,arr,st);
        ans += call(i,j-1,k+1,k2,arr,st);
        st[i][j]=false;
        return ans;
    }
}