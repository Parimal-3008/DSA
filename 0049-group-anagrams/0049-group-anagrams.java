class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        List<List<String>> res = new ArrayList<>();
        Map<String,List<String>> mp = new HashMap<>();
        for(String i:arr)
        {
            char ar[]= i.toCharArray();
            Arrays.sort(ar);
           String  ji="";
            for(char j:ar)
                ji= ji+ String.valueOf(j);
            List<String> list = new ArrayList<>();
            if(mp.containsKey(ji))
                list = mp.get(ji);
            list.add(i);
            mp.put(ji,list);
        }
        for(Map.Entry<String,List<String>> entry:mp.entrySet())
            res.add(entry.getValue());
        return res;
            
    }
}