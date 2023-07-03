class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        int pref[]= new int[arr.length];
        pref[0]=arr[0];
        for(int i=1;i<arr.length;i++)
            pref[i]=pref[i-1]+arr[i];
        int ans = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            pref[i]%=k;
            if(pref[i]<0)
                pref[i]+=k;
            if(mp.containsKey(pref[i]))
                ans+=mp.get(pref[i]);
            if(pref[i]==0)
                ans++;
            mp.put(pref[i],mp.getOrDefault(pref[i],0)+1);
        }
        return ans;
    }
}