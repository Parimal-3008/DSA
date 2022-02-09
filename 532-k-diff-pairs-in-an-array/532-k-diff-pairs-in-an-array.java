class Solution {
    public int findPairs(int[] arr, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            if(!mp.containsKey(arr[i]))
                mp.put(arr[i],1);
            else
                mp.put(arr[i],mp.get(arr[i])+1);
        }
        int count=0;
        for (Map.Entry<Integer,Integer> entry : mp.entrySet())
        {
            int a= entry.getKey();
            if(k==0)
            {
                int val =mp.get(a);
                if(val>1)
                {
                    count+= 2;
                    
                }
                continue;
            }
            if(mp.containsKey(a+k))
            {
                count++;
               
                
            }
             if(mp.containsKey(a-k))
            {
                count++;
               
                
            }
            
        }
        return count/2;
    }
}