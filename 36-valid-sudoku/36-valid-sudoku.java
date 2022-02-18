class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean st= true;
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
               { st = isok(board,i,j,board[i][j]);
                
                if(!st) return st;}
            }
               
        return true;
    }
     public boolean isok(char arr[][],int i, int j,char x) {
        for(int p=0;p<9;p++)
        {
            if(arr[i][p]==x&&p!=j)
                return false;
        }
         for(int p=0;p<9;p++)
        {
            if(arr[p][j]==x&&p!=i)
                return false;
        }
        for(int p=i/3*3;p<(i/3+1)*3;p++)
        {
            for(int q=j/3*3;q<(j/3+1)*3;q++)
            {
                if(arr[p][q]==x&&p!=i&&q!=j)
                    return false;
            }
        }
        return true;
    
    }
}