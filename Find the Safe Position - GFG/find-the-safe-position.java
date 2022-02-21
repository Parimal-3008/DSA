// { Driver Code Starts

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int k = Integer.parseInt(S[1]);

            Solution ob = new Solution();
            System.out.println(ob.safePos(n,k));
        }
    }
}// } Driver Code Ends



class Solution {
    static int safePos(int n, int k) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++)
        list.add(i);
       
        int j=(k-1)%n;
        while(list.size()>1)
        {
            int p= list.size();
            //System.out.println(list);
            int po=j;
            list.remove(j);
            j=(po+k-1)%(p-1);
           
            
            
            
        }
        //System.out.println(list);
        return list.get(0);
    }
};