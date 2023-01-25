class Solution {
    public int closestMeetingNode(int[] arr, int node1, int node2) {
        Map<Integer,Integer> mp = new HashMap<>();
      int curr =0;
      while(node1!=-1)
      {
        if(mp.containsKey(node1))
          break;
        mp.put(node1,curr);
        curr++;
        node1=arr[node1];
      }
      int min = Integer.MAX_VALUE;
      int ind = -1;
      curr=0;
     Set<Integer> mp2 = new HashSet<>();
       while(node2!=-1)
      {
         if(mp2.contains(node2))
           break;
       if(mp.containsKey(node2))
       {
         if(min>Math.max(mp.get(node2),curr))
         {
           min = Math.max(mp.get(node2),curr);
           ind = node2;
         }
         else if(min ==Math.max(mp.get(node2),curr))
         {
           ind = Math.min(ind,node2);
         }
       }
         
         mp2.add(node2);
        curr++;
        node2=arr[node2];
      }
      // System.out.println(mp);
      // System.out.println(mp2);
      
      return ind;
    }
}