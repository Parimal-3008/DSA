class Solution {
    public int numOfMinutes(int n, int headID, int[] man, int[] inf) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<n;i++)
            list.add(new ArrayList<>());
        int dist[]= new int[n];
        for(int i=0;i<n;i++)
           if(man[i]!=-1)
               list.get(man[i]).add(i);
        Queue<Integer> q = new LinkedList<>();
        Arrays.fill(dist,0);
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(i+":");
        //     for(int j:list.get(i))
        //         System.out.print(j+" ");
        //     System.out.println();
        // }
        q.add(headID);
        int max=0;
        while(!q.isEmpty())
        {
            int e = q.poll();
            for(int i:list.get(e))
            {
                q.add(i);
                dist[i]=dist[e]+inf[e];
                //System.out.println(dist[i]);
                max=Math.max(max,dist[i]);
            }
        }
        return max;
    }
}