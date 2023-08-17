class Solution {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] arr= new char[n][n];
        for(char i[]:arr)
            Arrays.fill(i,'.');
        for(int i=0;i<n;i++)
        {
            arr[0][i]='Q';
            call(1,arr,n);
            arr[0][i]='.';
        }
        return list;
    }
    public void call(int i, char[][] arr, int n)
    {
        if(i==n)
        {
            List<String> temp = new ArrayList<>();
            for(char[] i1:arr)
            {
                String ans="";
                for(char j:i1)
                    ans+=String.valueOf(j);
            temp.add(ans);
            }
            list.add(temp);
            return;
        }
        for(int j=0;j<n;j++)
        {
            if(ispossible(i,j,arr))
            {
                arr[i][j]='Q';
                call(i+1,arr,n);
                arr[i][j]='.';
            }
        }
        
    }
    public boolean ispossible(int i, int j,char[][] arr)
    {
        for(int k=0;k<i;k++)
        {
            if(arr[k][j]=='Q')
                return false;
        }
        int p=i; int q=j;
        while(p>=0 && q>=0)
        {
            if(arr[p][q]=='Q')
                return false;
            p--;q--;
        }
         p=i;  q=j;
        while(p>=0 && q<arr.length)
        {
            if(arr[p][q]=='Q')
                return false;
            p--;q++;
        }
        return true;
    }
}