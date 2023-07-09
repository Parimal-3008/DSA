class Solution {
    public void rotate(int[][] arr) {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                swap(i,j,arr);
            }
        }
        for(int j=0;j<arr[0].length/2;j++)
        {
           swap2(j,arr[0].length-1-j,arr);
        }
        
    }
    public void swap2(int j1, int j2,int[][] arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            int temp = arr[i][j1];
            arr[i][j1]=arr[i][j2];
            arr[i][j2]=temp;
        }
    }
    public void swap(int i, int j, int[][] arr)
    {
        int temp = arr[i][j];
        arr[i][j]=arr[j][i];
        arr[j][i]=temp;
    }
}