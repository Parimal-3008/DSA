class Solution {
    public int destroyTargets(int[] arr, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i:arr)
        {
            int rem = i%k;
            if(!mp.containsKey(rem))
                mp.put(rem,1);
            else
                mp.put(rem,mp.get(rem)+1);
        }
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry:mp.entrySet())
        {
            if(entry.getValue()>max)
            {
                set= new HashSet<>();
                set.add(entry.getKey());
                max = entry.getValue();
            }
            else if(entry.getValue()==max)
            {
                set.add(entry.getKey());
            }
                
        }
        int min = Integer.MAX_VALUE;
         for(int i:arr)
        {
            int rem = i%k;
             if(set.contains(rem))
             {
                 min = Math.min(min,i);
             }
         }
        return min;
    }
}