// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    ArrayList<String> NBitBinary(int n) {
        ArrayList<String> list = new ArrayList<>();
        call(list,n,"",0,0);
        return list;
    }
    public void call( ArrayList<String> list ,int n,String curr, int o,int z)
    {
        
        if(z+o==n)
        {
            list.add(curr);return;
        }
        if(o<n)
        call(list,n,curr+"1",o+1,z);
        if(z<o)
        call(list,n,curr+"0",o,z+1);
    }
}