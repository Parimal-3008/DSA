class Solution {
    public boolean exist(char[][] arr, String word) {
        boolean ans = false;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {    ans = ans || call(i,j,arr,0,word);
              if(ans)
                  return ans;
            }
        }
        return ans;
    }
    public boolean call(int i, int j, char[][] arr, int k, String str)
    {
        if(k==str.length())
            return true;
        if(i<0 || i==arr.length || j<0 || j==arr[0].length)
            return false;
        char ch = str.charAt(k);
        if(arr[i][j]=='.')
            return false;
        boolean ans = false;
        if(arr[i][j]==ch)
        {
            arr[i][j]='.';
            ans = ans || call(i+1,j,arr,k+1,str);
            ans = ans || call(i,j-1,arr,k+1,str);
            ans = ans || call(i-1,j,arr,k+1,str);
            ans = ans || call(i,j+1,arr,k+1,str);
            arr[i][j]=ch;
        }
        return ans;
    }
}