class Solution {
    public boolean canArrange(int[] arr, int k) {
        for(int i=0;i<arr.length;i++)
        {
            arr[i]%=k;
            if(arr[i]<0)
                arr[i]+=k;
        }
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i:arr)
            mp.put(i,mp.getOrDefault(i,0)+1);
        if(mp.containsKey(0))
        {
            int v = mp.get(0);
            if(v%2==1)
                return false;
        }
        System.out.println(mp);
        for(int i=1;i<k;i++)
        {
            
           if(mp.containsKey(i) && mp.containsKey(k-i) && (int)mp.get(i)==(int)mp.get(k-i))
                continue;
            else if(!mp.containsKey(i))
                continue;
           
                return false;
        }
        return true;
        
    }
}