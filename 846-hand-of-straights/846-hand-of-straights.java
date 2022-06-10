class Solution {
    public boolean isNStraightHand(int[] arr, int k) {
         Map<Integer,Integer> mp = new TreeMap<>();
      
        for(int i=0;i<arr.length;i++)
        {
            if(mp.containsKey(arr[i]))
            {
                mp.put(arr[i],mp.get(arr[i])+1);
            }
            else
            {
                mp.put(arr[i],1);
            }
        }
        
        while(mp.size()>0)
        {
         //int i=0;
            Iterator<Map.Entry<Integer, Integer>> iterator = mp.entrySet().iterator();
            Map.Entry<Integer, Integer> actualValue = iterator.next();
            int first = actualValue.getKey();
            for(int i=0;i<k;i++)
            {
                if(mp.containsKey(first+i))
                  { 
                    int val = mp.get(first+i);
                    if(val>1)
                    mp.put(first+i,mp.get(first+i)-1);
                    else
                        mp.remove(first+i);
                  }
                else
                    return false;
            }
        }
        return true;
            
    }
}