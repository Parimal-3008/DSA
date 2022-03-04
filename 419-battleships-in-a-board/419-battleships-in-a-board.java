class Solution {
    public int countBattleships(char[][] arr) {
        //boolean[][] vis= new boolean[arr.length][arr[0].length];
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]=='X')
                   count+= call(i,j,arr);
            }
        }
        return count;
    }
    public int call(int x, int y, char[][] arr)
    {
        if(x==arr.length||y==arr[0].length)
            return 0;
        if(arr[x][y]=='.'||arr[x][y]=='Y')
            return 0;
        if(arr[x][y]=='X')
        arr[x][y]='Y';
        int p = call(x+1,y,arr);
        int q = call(x,y+1,arr);
        return 1;
    }
}