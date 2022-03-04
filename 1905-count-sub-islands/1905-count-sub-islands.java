class Solution {
    public int countSubIslands(int[][] arr1, int[][] arr2) {
        int m= arr1.length;
        int n= arr1[0].length;int count=0;
        boolean vis[][] = new boolean[m][n];
          for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(arr1[i][j]==1&&arr2[i][j]==1)
                    arr2[i][j]=2;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
          if(!vis[i][j]&&arr2[i][j]==2)
                {
                  int st =call(vis,arr2,i,j);
                    if(st == 0)
                    {
                        //System.out.println(i+" "+j);
                        count++;
                    }
                }
           return count;
    }
    public int call(boolean vis[][],int arr2[][] , int i, int j)
    {
        if(i<0||i==arr2.length||j<0||j==arr2[0].length)
            return 0;
        if(arr2[i][j]==1)
            return 1;
        if(arr2[i][j]==0)
            return 0;
        if(vis[i][j]&&arr2[i][j]==2)
            return 0;
        vis[i][j]=true;
            int a1=call(vis,arr2,i+1,j);
            int a2=call(vis,arr2,i,j+1);
        int a3=call(vis,arr2,i-1,j);
        int a4=call(vis,arr2,i,j-1);
        
            return a1+a2+a3+a4;            
    }
}