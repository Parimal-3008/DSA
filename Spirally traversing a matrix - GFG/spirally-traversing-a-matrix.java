// { Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int arr[][], int r1234, int c12345)
    {
        int m=arr.length;
        int n=arr[0].length;
        boolean vis[][] =new boolean[m][n];
        int a=1;int i=0;int j=0;char ini='r';
        Map<Character,Character> mp=new HashMap<>();
        mp.put('l','u');
        mp.put('r','d');
        mp.put('d','l');
        mp.put('u','r');
        ArrayList<Integer> l=new ArrayList<>();
        while(a<=m*n)
        {
            vis[i][j]=true;a++;
            l.add(arr[i][j]);
            if(ini=='r')
                j=j+1;
            else if(ini=='l')
                j=j-1;
           else if(ini=='d')
                i++;
           else if(ini=='u')
                i=i-1;
            if(j>=n||j<0||i>=m||i<0)
            {
                ini=mp.get(ini);
                if(ini=='r')
                j=j+1;
            else if(ini=='l')
                j=j-1;
           else if(ini=='d')
                i++;
           else if(ini=='u')
                i=i-1;
                if(j>=n)
                j--;
                if(i<0)
                    i++;
                if(i>=m)
                i--;
                if(j<0)
                    j++;
                
            }
           if(vis[i][j])
           {
               if(ini=='r'){
                 j=j-1;i++;  
               }
                
            else if(ini=='l'){
                i--;j++;}
           else if(ini=='d'){
                i--;j--;}
           else if(ini=='u'){
                i=i+1;j++;}
               ini=mp.get(ini);
           }
        }
        return l;
    }
}
