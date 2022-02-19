class Solution {
    int count=0;
    public int uniquePathsWithObstacles(int[][] arr) {
          int m=arr.length;
        int n=arr[0].length;
        
        int[][] vis= new int[m][n];
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                vis[i][j]=-1;
        int p=call(arr,0,0,m-1,n-1,vis);
        return p;
    }
    public int call(int[][] arr, int s1,int e1,int s2,int e2,int[][] vis)
    {
        if(s1>=arr.length||s1<0||e1>=arr[0].length||e1<0)
            return 0;
        if(s1==s2 && e1==e2 && arr[s1][e1]==0 )
        {
           count++;
            return 1;
        }
        
        if(arr[s1][e1]==1)
            return 0;
        if(vis[s1][e1]!=-1)
            return vis[s1][e1];
        
        int m =call(arr,s1+1,e1,s2,e2,vis);
        int n =call(arr,s1,e1+1,s2,e2,vis);
        return vis[s1][e1] = m+n;
        
    }
}