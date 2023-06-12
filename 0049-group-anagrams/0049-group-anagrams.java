class Solution {
    public List<List<String>> groupAnagrams(String[] arr) {
        Map<String, List<String>> mp = new HashMap<>();
        for(String i:arr)
        {
            char temp[]= i.toCharArray();
            Arrays.sort(temp);
            String yu="";
            for(char j:temp)
                yu+=String.valueOf(j);
            List<String> list = new ArrayList<>();
            if(mp.containsKey(yu))
                list = mp.get(yu);
            list.add(i);
            mp.put(yu,list);
        }
        List<List<String>> list = new ArrayList<>();
        for(Map.Entry<String,List<String>> entry:mp.entrySet())
        {
            List<String> l = entry.getValue();
            list.add(l);
        }
        return list;
    }
}