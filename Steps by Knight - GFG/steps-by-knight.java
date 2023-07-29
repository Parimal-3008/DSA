//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int arr1[], int arr2[], int n)
    {
        // Code here
        int[][] arr= new int[n+1][n+1];
        for(int i[]:arr)
        Arrays.fill(i,Integer.MAX_VALUE-10000);
        Queue<int[]> q = new LinkedList<>();
        arr[arr1[0]][arr1[1]]=0;
        q.add(arr1);
        while(!q.isEmpty())
        {
            int[] arr3=q.poll();
            int a1=arr3[0];int a2=arr3[1];
            // System.out.println(a1+","+a2+" ->"+arr[a1][a2]);
            if(a1+1<=n&& a2+2<=n && arr[a1+1][a2+2]>arr[a1][a2]+1)
            {
                arr[a1+1][a2+2]=arr[a1][a2]+1;
                int[] temp={a1+1,a2+2};
                q.add(temp);
            }
             if(a1+1<=n&& a2-2>=0 && arr[a1+1][a2-2]>arr[a1][a2]+1)
            {
                arr[a1+1][a2-2]=arr[a1][a2]+1;
                int[] temp={a1+1,a2-2};
                q.add(temp);
            }
             if(a1-1>=0&& a2-2>=0 && arr[a1-1][a2-2]>arr[a1][a2]+1)
            {
                arr[a1-1][a2-2]=arr[a1][a2]+1;
                int[] temp={a1-1,a2-2};
                q.add(temp);
            }
             if(a1-1>=0&& a2+2<=n && arr[a1-1][a2+2]>arr[a1][a2]+1)
            {
                arr[a1-1][a2+2]=arr[a1][a2]+1;
                int[] temp={a1-1,a2+2};
                q.add(temp);
            }
           
           
           if(a1+2<=n&& a2+1<=n && arr[a1+2][a2+1]>arr[a1][a2]+1)
            {
                arr[a1+2][a2+1]=arr[a1][a2]+1;
                int[] temp={a1+2,a2+1};
                q.add(temp);
            }
             if(a1+2<=n&& a2-1>=0 && arr[a1+2][a2-1]>arr[a1][a2]+1)
            {
                arr[a1+2][a2-1]=arr[a1][a2]+1;
                int[] temp={a1+2,a2-1};
                q.add(temp);
            }
             if(a1-2>=0&& a2-1>=0 && arr[a1-2][a2-1]>arr[a1][a2]+1)
            {
                arr[a1-2][a2-1]=arr[a1][a2]+1;
                int[] temp={a1-2,a2-1};
                q.add(temp);
            }
             if(a1-2>=0&& a2+1<=n && arr[a1-2][a2+1]>arr[a1][a2]+1)
            {
                arr[a1-2][a2+1]=arr[a1][a2]+1;
                int[] temp={a1-2,a2+1};
                q.add(temp);
            }
        }
        return arr[arr2[0]][arr2[1]];
    }
}