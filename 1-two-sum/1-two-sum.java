class Solution {
    class Edge
    {
        int n;int ind;
        public Edge(int n, int ind)
        {
            this.n=n;this.ind=ind;
        }
    }
     class comp implements Comparator<Edge>
    {
        @Override
        public int compare(Edge s1, Edge s2)
        {
            if(s1.n>s2.n)
                return 1;
            else 
                return -1;     
                
        }
    }
    public int[] twoSum(int[] arr2, int k) {
        Edge arr[]= new Edge[arr2.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=new Edge(arr2[i],i);
        }
        Arrays.sort(arr,new comp());
        int ans[]= new int[2];
        int l =0;
        int r= arr.length-1;
        while(l<r)
        {
            int s=arr[l].n+arr[r].n;
            if(s==k)
            {
                ans[0]=arr[l].ind;ans[1]=arr[r].ind;
                return ans;
            }
            if(s<k)
                l++;
            else
                r--;
            
        }
        return ans;
    }
}