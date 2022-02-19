class Solution {
    int count=0;
    public int uniquePathsIII(int[][] arr) {
        int s1=0,s2=0,e1=0,e2=0;int m=arr.length;
        int n=arr[0].length;int tot = (m*n);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==1)
                    {s1=i;e1=j;}
                else if(arr[i][j]==2)
                {s2=i;e2=j;}
                else if(arr[i][j]==-1)
                    tot--;
            }
        }
        System.out.println(s1+" "+e1+" "+s2+" "+e2+" "+tot);
        boolean[][] vis= new boolean[m][n];
        call(arr,s1,e1,s2,e2,vis,tot);
        return count;
    }
    public void call(int[][] arr, int s1,int e1,int s2,int e2,boolean[][] vis,int req)
    {
        if(s1>=arr.length||s1<0||e1>=arr[0].length||e1<0||vis[s1][e1])
            return;
        if(s1==s2 && e1==e2 &&req==1 )
        {
           count++;
            return;
        }
        
        if(arr[s1][e1]==-1)
            return;
        vis[s1][e1]=true;
        call(arr,s1+1,e1,s2,e2,vis,req-1);
        call(arr,s1,e1+1,s2,e2,vis,req-1);
        call(arr,s1-1,e1,s2,e2,vis,req-1);
        call(arr,s1,e1-1,s2,e2,vis,req-1);
        vis[s1][e1]=false;
        
    }
}