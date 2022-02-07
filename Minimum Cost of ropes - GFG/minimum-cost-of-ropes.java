// { Driver Code Starts
//Initial Template for Java

import java.math.*;
import java.util.*;
import java.io.*;

class Driverclass
{
    // Driver Code
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
        
        Long nextLong(){
            return Long.parseLong(next());
        }
    }
    
	public static void main(String args[])
	{
		FastReader sc = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = sc.nextInt();
		
		while(t>0)
		{
			int n = sc.nextInt();
			long arr[] = new long[n];
			
			for(int i=0; i<n; i++)
				arr[i] = sc.nextLong();
		    out.println(new Solution().minCost(arr, n));
		    t--;
		}
		out.flush();
	}
}// } Driver Code Ends


class Solution
{
 public static class Edge
    {
        long x;
        public Edge(long x)
        {
            this.x=x;
        }
    }
    public static class Com implements Comparator<Edge>
    {
        @Override
        public int compare(Edge s1, Edge s2)
        {
            if(s1.x>s2.x)
                return 1;
            else
                return -1;
        }
    }
    //Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) 
    {
        long cost =0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(new Com());
        for(long i:arr)
        {
            pq.add(new Edge(i));
           
        }
        while(pq.size()>=2)
        {
            Edge e1 = pq.poll();
            Edge e2 = pq.poll();
            long sum = e1.x+e2.x;
            cost+=sum;
            pq.add(new Edge(sum));
        }
        return cost;
    }
}