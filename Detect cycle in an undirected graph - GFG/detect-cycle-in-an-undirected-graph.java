// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    static class Edge
    {
        int n;int parent;
        public Edge(int n,int parent)
        {
            this.n=n;
            this.parent=parent;
        }
    }
    // Function to detect cycle in an undirected graph.
    public  boolean isCycle(int V, ArrayList<ArrayList<Integer>> l) {
        boolean visited[] = new boolean[V];
        Arrays.fill(visited,false);
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            {
                if(check(i,visited,l))
                return true;
            }
        }
        return false;
        // Code here
    }
    public static boolean check(int i, boolean[] visited,ArrayList<ArrayList<Integer>> l )
    {
        Stack<Edge> q = new Stack<>();
        q.push(new Edge(i,-1));
        while(!q.isEmpty())
        {
            Edge e = q.pop();
            visited[e.n]=true;
            for(int j: l.get(e.n))
            {
                if(!visited[j])
                {
                    q.push(new Edge(j,e.n));
                    visited[e.n]=true;
                }
                else
                {
                    if(e.parent!=j)
                    return true;
                }
            }
        }
        return false;
    }
}