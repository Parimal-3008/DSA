class Solution {
    public boolean containsCycle(char[][] arr) {
        int m =arr.length;
        int n =arr[0].length;
        boolean visited[][]= new boolean[m][n];
        boolean st=false;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(!visited[i][j])
                     {
                       st= st||call(arr,visited,i,j,arr[i][j],' ');
                       if(st)
                          return st;
                      }
        return st;

    }
    public boolean call(char[][] arr, boolean[][] vis,int p,int q, char c,char ch)
    {
        if(p==arr.length||p<0||q==arr[0].length||q<0)
            return false;
        if(arr[p][q]!=c)
            return false;
        if(vis[p][q])
            return true;
        vis[p][q]=true;
        boolean a1= false,a2= false,a3= false,a4 = false;
        if(ch!='U')
         a1= call(arr,vis,p+1,q,arr[p][q],'D');
        if(ch!='D')
         a2= call(arr,vis,p-1,q,arr[p][q],'U');
        if(ch!='L')
         a3= call(arr,vis,p,q+1,arr[p][q],'R');
        if(ch!='R')
         a4= call(arr,vis,p,q-1,arr[p][q],'L');
        //vis[p][q]=false;
        return a1||a2||a3||a4;
    }
}