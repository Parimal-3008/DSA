class Solution {
    public void solve(char[][] arr) {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i][0]=='O')
                call1(i,0,arr);
        }
        for(int i=0;i<arr[0].length;i++)
        {
            if(arr[0][i]=='O')
                call1(0,i,arr);
        }
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i][arr[0].length-1]=='O')
                call1(i,arr[0].length-1,arr);
        }
        for(int i=0;i<arr[0].length;i++)
        {
            if(arr[arr.length-1][i]=='O')
                call1(arr.length-1,i,arr);
        }
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]=='O')
                    arr[i][j]='X';
            }
        }
         for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]=='*')
                    arr[i][j]='O';
            }
         }
        
        
    }
    public void call1(int i, int j, char[][] arr)
    {
        if(i<0 || j<0 ||i==arr.length || j==arr[0].length)
            return ;
        if(arr[i][j]=='X' ||arr[i][j]=='*')
            return;
        arr[i][j]='*';
        call1(i+1,j,arr);
        call1(i,j+1,arr);
        call1(i-1,j,arr);
        call1(i,j-1,arr);
    }
}