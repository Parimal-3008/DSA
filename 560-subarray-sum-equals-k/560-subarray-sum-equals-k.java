class Solution {
    public int subarraySum(int[] arr, int k) {
        int count=0;int sum=0;
       Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<arr.length;i++)
        {
            sum+=arr[i];
            if(mp.containsKey(-k+sum))
                 count+=mp.get(-k+sum);
            if(mp.containsKey(sum))
                 mp.put(sum,mp.get(sum)+1);
            else
                 mp.put(sum,1);
        }
        return count;
    }
}