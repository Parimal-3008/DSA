class Solution {
    int p1= 31, m1 = 1000000007;
    public String replaceWords(List<String> dict, String sent) {
        Map<Integer,String> mp = new HashMap<>();
        for(String i:dict)
            mp.put(hash(i),i);
        String arr[]= sent.split("\\s+");
        for(int i=0;i<arr.length;i++)
        {
            String tp= call(arr[i],mp);
            if(!tp.equals("@"))
                arr[i]=tp;
        }
        String ans="";
        for(String i:arr)
            ans=ans + i+" ";
        return ans.trim();
    }
    public String call(String S,Map<Integer,String> mp)
    {
         int hash_so_far = 0;
        final char[] s_array = S.toCharArray();
        long p_pow = 1;
        final int n = s_array.length;
        for (int i = 0; i < n; i++) {
            hash_so_far = (int)((hash_so_far + (s_array[i] - 'a' + 1) * p_pow) % m1);
            p_pow = (p_pow * p1) % m1;
            if(mp.containsKey(hash_so_far))
                return mp.get(hash_so_far);
        }
        return "@";
    }
    public int hash(String S)
    {
        int hash_so_far = 0;
        final char[] s_array = S.toCharArray();
        long p_pow = 1;
        final int n = s_array.length;
        for (int i = 0; i < n; i++) {
            hash_so_far = (int)((hash_so_far + (s_array[i] - 'a' + 1) * p_pow) % m1);
            p_pow = (p_pow * p1) % m1;
        }
        return hash_so_far;
    }
}