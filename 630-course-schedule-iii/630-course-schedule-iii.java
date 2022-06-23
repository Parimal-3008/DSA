class Solution {
    class Edge
    {
        int a;int b;
        public Edge(int a, int b)
        {
            this.a=a;
            this.b=b;
        }
    }
   
    class Comp implements Comparator<Edge>
    {
        @Override
        public int compare(Edge e1, Edge e2)
        {
            int res = Integer.compare(e2.a,e1.a);
            if(res==0)
                res = Integer.compare(e2.b,e1.b);
            return res;
        }
    }
    public int scheduleCourse(int[][] arr) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comp());
        Arrays.sort(arr, new Comparator<int[]>(){
            @Override
        public int compare(int[] e1, int[] e2)
        {
            int res = Integer.compare(e1[1],e2[1]);
            if(res==0)
                res = Integer.compare(e1[0],e2[0]);
            return res;
        }
        });
        int curr=0;
        int ans=0;
        for(int i=0;i<arr.length;i++)
         {
             Edge obj = new Edge(arr[i][0],arr[i][1]);
           // pq.add(obj); 
        }
        //PriorityQueue<Edge> pq2 = new PriorityQueue<Edge>(new Comp());
        for(int i=0;i<arr.length;i++)
        {
            Edge obj = new Edge(arr[i][0],arr[i][1]);
            if(arr[i][1]>=curr+arr[i][0])
            {
                ans++;
                curr+=arr[i][0];
                 pq.add(obj); 
            }
            else
            {
               // while(pq.size()>0)  
                if(pq.size()>0)
                {
                     Edge e = pq.poll();
                if(e.a>obj.a)
                   { pq.add(obj);
                     curr-=e.a;
                    curr+=obj.a;
                   }
                else
                    pq.add(e);   
                }
                                
            }
                
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }        
        // while(pq.size()>0)
        // {
        //     Edge e = pq.poll();
        //     System.out.println(e.a+" "+ e.b);
        //     // if(e.b>=curr+e.a)
        //     // {
        //     //     ans++;
        //     //     curr+=e.a;
        //     // }
        // }     
        return ans;
    }
}