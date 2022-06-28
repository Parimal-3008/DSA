class Solution {
     public int minDeletions(String str) {
        int arr[]= new int[26];
       for(int i=0;i<str.length();i++)
       {
         char ch = str.charAt(i);
         arr[ch -'a']++;
       }
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>(new Comparator<Integer>() {                   
                    // Compare method for place element in
                    // reverse order
                    public int compare(Integer a, Integer b)
                    {
                        if (a < b)
                            return 1;
                        else
                            return -1;
                        
                    }
                });
       for(int i:arr)
       {
         if(i!=0)
           pq.add(i);
       }
       int prev = pq.poll(); int ans=0;
       while(pq.size()>0)
        {
         int curr = pq.poll();         
         if(prev == curr)
         {
           ans++;
           curr--;
           if(curr!=0)
           pq.add(curr);
         }
         else
           prev=curr;
         //System.out.println(pq.poll());
       }      
       return ans;
    }
}