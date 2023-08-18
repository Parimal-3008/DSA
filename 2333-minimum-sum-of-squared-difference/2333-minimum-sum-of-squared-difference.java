class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] arr= new int[nums1.length];
        Map<Integer,Integer> mp = new HashMap<>();
         PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int k = k1+k2;
        for(int i=0;i<arr.length;i++)
        {
            int d = Math.abs(nums1[i]-nums2[i]);
            if(!mp.containsKey(d))
                pq.add(d);
            mp.put(d,mp.getOrDefault(d,0)+1);
        }
        // System.out.println(mp);
        long ans = 0;
       while(k>0 && !pq.isEmpty())
       {
           int t = pq.poll();           
           int freq = mp.get(t);
           if(!pq.isEmpty())
           {
               int t2= pq.peek();
               if(k>=(t-t2)*freq)
               {
                   k-=(t-t2)*freq;
                   mp.remove(t);
                   mp.put(t2,mp.get(t2)+freq);
               }
               else
               {
                   int diff = k/freq;
                   int rem = k%freq;
                   mp.remove(t);
                   if(!mp.containsKey(t-diff-1))
                  {
                       pq.add(t-diff-1);
                       mp.put(t-diff-1,rem);
                  }
                   else
                       mp.put(t-diff-1,mp.get(t-diff-1)+rem);
                   
                   if(!mp.containsKey(t-diff))
                  {
                       pq.add(t-diff);
                       mp.put(t-diff,freq-rem);
                  }
                   else
                       mp.put(t-diff,mp.get(t-diff)+freq-rem);
                   break;
               }
           }
           else
           {
                int diff = k/freq;
                   int rem = k%freq;
                   mp.remove(t);
                   if(!mp.containsKey(t-diff-1))
                  {
                       pq.add(t-diff-1);
                       mp.put(t-diff-1,rem);
                  }
                   else
                       mp.put(t-diff-1,mp.get(t-diff-1)+rem);
                   
                   if(!mp.containsKey(t-diff))
                  {
                       pq.add(t-diff);
                       mp.put(t-diff,freq-rem);
                  }
                   else
                       mp.put(t-diff,mp.get(t-diff)+freq-rem);
               break;
           }
           // System.out.println(mp);
           
        
       }
        // System.out.println(mp);
      for(Map.Entry<Integer,Integer> entry:mp.entrySet())
        {
            long t =(long) entry.getKey();
            long freq= (long)entry.getValue();
          if(t>0)
           ans+=(t*t*freq);
        }
        return ans;
        
        
    }
}