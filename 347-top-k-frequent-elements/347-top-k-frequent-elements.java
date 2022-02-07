class Solution {
    class Edge
    {
        int data;
        int wt;
      
        public Edge (int data ,int x)
        {
            this.data= data;
            this.wt =x;
            
        }
    }
     class Com implements Comparator<Edge>
     {
         @Override
         public int compare(Edge s1, Edge s2)
         {
             if(s1.wt>s2.wt)
                 return 1;
             else
                 return -1;
         }
     }
    public int[] topKFrequent(int[] arr, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(!mp.containsKey(arr[i]))
                mp.put(arr[i],1);
            else
                mp.put(arr[i],mp.get(arr[i])+1);
        }
        PriorityQueue<Edge> pq =  new PriorityQueue<Edge>(new Com());
         for (Map.Entry<Integer,Integer> entry : mp.entrySet())
         {
             pq.add(new Edge(entry.getKey(),entry.getValue()));
             if(pq.size()>k)
                 pq.poll();
         }
        int nums[]=new int[k];
        int i=0;
        while(!pq.isEmpty())
        {
            nums[i]=pq.poll().data;
            i++;
        }
        return nums;
            
    }
}