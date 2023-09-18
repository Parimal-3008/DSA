class Solution {
    class Edge
    {
        int n;int ind;
        public Edge(int n,int ind)
        {
            this.n=n;
            this.ind=ind;
        }
    }
    class com implements Comparator<Edge>
    {
        @Override
        public int compare(Edge s1,Edge s2)
        {
            if(s1.n>s2.n)
                return 1;
            else if(s1.n<s2.n)
                return -1;
            else
            {
                if(s1.ind<s2.ind)
                    return -1;
                else
                    return 1;
            }
        }

    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int arr[]= new int[mat.length];
        for(int i=0;i<mat.length;i++)
        {
            int count=0;
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==1)
                    count++;
                else
                    break;
            }
            arr[i]=count;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(k,new com());
        for(int i=0;i<arr.length;i++)
        {
            pq.add(new Edge(arr[i],i));
        }
        int arr2[]= new int[k];
        int i=0;
        while(i<k)
        {
            arr2[i]=pq.poll().ind;
            i++;
        }
        return arr2;
    }
}