class Solution {
    public int numIdenticalPairs(int[] arr) {
        HashMap<Integer,Integer> mp= new HashMap<>();
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
             int y= entry.getValue();
             count+= (y*(y-1))/2;
         }
        return count;
    }
}