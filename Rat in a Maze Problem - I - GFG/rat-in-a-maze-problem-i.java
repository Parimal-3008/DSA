// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] arr, int n) {
        // Your code here
        ArrayList<String> list = new ArrayList<>();
        boolean[][] vis= new boolean[n][n];
        call(arr,0,0,list,"",n,vis);
        return list;
    }
    public static void call(int[][] arr, int p, int q, ArrayList<String> list, String curr,int n,boolean[][] vis)
    {
        if(arr[n-1][n-1]==0)
        return;
        if(p==n-1&&q==n-1)
        {
            list.add(curr);
            return;
        }
        if(p==n ||q==n ||p==-1||q==-1)
        return;
        if(vis[p][q] || arr[p][q]==0)
        return;
        vis[p][q]=true;
        call(arr,p+1,q,list,curr+"D",n,vis);
        call(arr,p-1,q,list,curr+"U",n,vis);
        call(arr,p,q+1,list,curr+"R",n,vis);
        call(arr,p,q-1,list,curr+"L",n,vis);
        vis[p][q]=false;
    }
}