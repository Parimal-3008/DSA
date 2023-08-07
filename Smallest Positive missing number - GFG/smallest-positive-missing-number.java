//{ Driver Code Starts
import java.util.*;
import java.io.*;


// } Driver Code Ends

class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int n)
    {
        // Your code here
         int count =0;
      for(int i:arr)
      {
        if(i==1)
          count++;
      }
      if(count ==0)
        return 1;
      for(int i=0;i<arr.length;i++)
      {
        if(arr[i]>arr.length|| arr[i]<1)
          arr[i]=1;        
      }
      for(int i=0;i<arr.length;i++)
      {
        int p = arr[i];
        if(p<0)
          p*=(-1);
        p--;
        if(arr[p]>0)
          arr[p]*=(-1);
      }
      for(int i=0;i<arr.length;i++)
      {
        if(i!=0 && arr[i]>0)
          return i+1;
      }
      return arr.length+1;
     
    }
}


//{ Driver Code Starts.

class Main
{   
    public static void main (String[] args) throws IOException
    {

		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		
        //taking testcases
		int t=Integer.parseInt(in.readLine().trim());
		while(t-->0){
		    
		    //input number n
			int n=Integer.parseInt(in.readLine().trim());
			int[] arr=new int[n];
			String s[]=in.readLine().trim().split(" ");
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i]=Integer.parseInt(s[i]);
				
			Solution obj = new Solution();
			
			//calling missingNumber()
			int missing = obj.missingNumber(arr,n);
			out.println(missing);
		}
		out.close();
    }
}


// } Driver Code Ends