class Solution {
    char univ[][]= new char[9][9];
    public void solveSudoku(char[][] arr) {      
        traverse(arr,0,0);
        System.out.println("yoyoyoyoy");
         for(int i=0;i<9;i++)
               for(int j=0;j<9;j++)
                   arr[i][j]=univ[i][j];
    }
    public  void traverse(char arr[][],int i, int j) {
        
        if(i>=9)
        {
               for(int p=0;p<9;p++){
                for(int q=0;q<9;q++)
                       {System.out.print(arr[p][q]+" ");
                        univ[p][q]=arr[p][q];
                       }
                   System.out.println();}        
            return;
        }
        if(arr[i][j]=='.')
        {
                   for(int p=0;p<9;p++)
                   {
                       if(isok(arr,i,j,p+1))
                       {
                           arr[i][j]=Integer.toString(p+1).charAt(0);;
                           if(j+1==9)
                               traverse(arr,i+1,0);
                           else
                               traverse(arr,i,j+1);
                          arr[i][j]='.';
                       }
                   }
        }
        else
        {
        if(j+1==9)
                               traverse(arr,i+1,0);
                           else
                               traverse(arr,i,j+1);
        }
    }

    public boolean isok(char arr[][],int i, int j, int x) {
        for(int p=0;p<9;p++)
        {
            if(arr[i][p]==Integer.toString(x).charAt(0)&&p!=j)
                return false;
        }
         for(int p=0;p<9;p++)
        {
            if(arr[p][j]==Integer.toString(x).charAt(0)&&p!=i)
                return false;
        }
        for(int p=i/3*3;p<(i/3+1)*3;p++)
        {
            for(int q=j/3*3;q<(j/3+1)*3;q++)
            {
                if(arr[p][q]==Integer.toString(x).charAt(0)&&p!=i&&q!=j)
                    return false;
            }
        }
        return true;
    
    }

}