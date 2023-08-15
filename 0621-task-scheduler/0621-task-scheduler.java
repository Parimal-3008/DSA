class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[][] arr= new int[26][2];
        for(char i:tasks)
        {
            arr[i-'A'][0]++;
            arr[i-'A'][1]= i-'A';
        }
        int ans = tasks.length;
        int extra = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<26;i++)
        {
            if(arr[i][0]>0)
                pq.add(arr[i]);
            // System.out.println(i+" "+arr[i][0]);
        }
        while(!pq.isEmpty())
        {
            List<int[]> list = new ArrayList<>();
           for(int i=0;i<=n;i++)
           {
               if(!pq.isEmpty())
                {
                   int temp[]=pq.poll();
                   temp[0]--;
                   if(temp[0]>0)
                       list.add(temp);
                }
               else if(!list.isEmpty())
                   extra++;
           }
             for(int[] i:list)
                 pq.add(i);
        }
        return ans+extra;
    }
}