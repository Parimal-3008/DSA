// { Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to delete middle element of a stack.
    public void deleteMid(Stack<Integer>st,int n){
        // code here
        int mid = (int)Math.ceil((double)n/2.0);
        if(n%2==0)
        call(st,mid,0);
        else
        call(st,mid,01);
        
        
    } 
    public void call(Stack<Integer> st, int mid,int curr)
    {
        if(mid == curr)
        {
            st.pop();return;
            
        }
        int p = st.pop();
        call(st,mid,curr+1);
        st.push(p);
    }
}

