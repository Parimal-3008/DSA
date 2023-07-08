class Solution {
    public int numIslands(char[][] arr) {
        int ans = 0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]=='.' || arr[i][j]=='0')
                    continue;
                call(i,j,arr);
                ans++;
            }
        }
        return ans;
    }
    public void call(int i,int j, char arr[][])
    {
        if(i==arr.length|| i<0 || j<0 || j==arr[0].length)
            return;
        if(arr[i][j]=='0' || arr[i][j]=='.')
            return;
        arr[i][j]='.';
        call(i+1,j,arr);
        call(i-1,j,arr);
        call(i,j+1,arr);
        call(i,j-1,arr);
        
    }
}