class Solution {
    public List<List<Integer>> groupThePeople(int[] arr) {
        Map<Integer,List<Integer>> mp = new HashMap<>();
         List<List<Integer>> list = new LinkedList<>();
         for(int i=0;i<arr.length;i++)
         {
             if(!mp.containsKey(arr[i]))
             {
                 List<Integer> l= new LinkedList<>();
                 l.add(i);
                 mp.put(arr[i],l);
             }
             else
             {
                 List<Integer> l = mp.get(arr[i]);
                 l.add(i);
             }
         }
        //System.out.println(mp);
        for(Map.Entry<Integer,List<Integer>> entry:mp.entrySet())
        {
            int p = entry.getKey();
            List<Integer> l1 = entry.getValue(); 
            List<Integer> l = new LinkedList<>();
            for(int i=0;i<l1.size();i++)
            {
                l.add(l1.get(i));
                if(l.size()==p)
                {
                    list.add(new LinkedList<>(l));
                    l= new LinkedList<>();
                }
            }
        }
        return list;
    }
}