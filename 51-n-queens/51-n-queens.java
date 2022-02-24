class Solution {
    public List<List<String>> solveNQueens(int n) {
        char arr[][]= new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                arr[i][j]='.';
        List<List<String>> list = new LinkedList<>();
        call(arr,0,list);
        return list;
    }
    public void call(char[][] arr, int p,List<List<String>> list  )
    {
        int n= arr.length;
        if( p==n)
        {
            
            List<String> temp = new LinkedList<>();
            for(int i=0;i<n;i++)
            {
                String str="";
                for(int j=0;j<n;j++)
                    str+=String.valueOf(arr[i][j]);
                temp.add(str);
            }
            list.add(temp);
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(canplace(arr,p,i))
            {
                arr[p][i]='Q';
                call(arr,p+1,list);
                arr[p][i]='.';
            }
        }
    }
    public boolean canplace(char[][] arr, int p,int q)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[p][i]=='Q'&& i!=q)
                return false;
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i][q]=='Q'&& i!=p)
                return false;
        }
        int x,y =0;int  n= arr.length;
        
        x=p;y=q;
        while(x>=0&&y<n)
        {
            if(arr[x][y]=='Q'&&x!=p&&y!=q)
                return false;
            x--;y++;
        }
         x=p;y=q;
        while(x>=0&&y>=0)
        {
            if(arr[x][y]=='Q'&&x!=p&&y!=q)
                return false;
            x--;y--;
        }
     
        return true;
    }
}