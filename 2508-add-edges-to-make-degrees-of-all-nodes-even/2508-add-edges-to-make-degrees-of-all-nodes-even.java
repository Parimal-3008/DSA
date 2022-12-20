class Solution {
    public boolean isPossible(int n, List<List<Integer>> list) {
        Map<Integer,Set<Integer>> mp = new HashMap<>();int count =0;
      int arr[]= new int[n+1];
      for(List<Integer> l:list)
      {
        int a = l.get(0);
        int b = l.get(1);
        if(!mp.containsKey(a))
          mp.put(a,new HashSet<>());
        if(!mp.containsKey(b))
          mp.put(b,new HashSet<>());
        Set<Integer> set = mp.get(a);set.add(b);
        mp.put(a,set);
        Set<Integer> set2 = mp.get(b);
        set2.add(a);
        mp.put(b,set2);
        arr[a]++;
        arr[b]++;
      }
      List<Integer> odd = new ArrayList<>();List<Integer> even = new ArrayList<>();
      for(int i=1;i<=n;i++)
      {
        if(arr[i]%2==1){
          count++;odd.add(i);}
        else
          even.add(i);
      }
      if( count ==0)
        return true;
      if(count>4 || count == 3 || count == 1)
        return false;
      if(count ==2)
      {
        Set<Integer> set = new HashSet<>();
        for(int i:even)
        {
           if(!mp.get(odd.get(0)).contains(i))
             set.add(i);
        }
        for(int i:even)
        {
           if(!mp.get(odd.get(1)).contains(i) && set.contains(i))
             return true;
        }
        //  if(mp.get(odd.get(0)).contains(odd.get(1)) && even.size()==0)
        //    return false;
        if(!mp.get(odd.get(0)).contains(odd.get(1)))
          return true;
        // if(mp.get(odd.get(0)).size()==n-1 || mp.get(odd.get(1)).size()==n-1)
        //   return false;
        return false;
      }
      if(!mp.get(odd.get(0)).contains(odd.get(1)) && !mp.get(odd.get(2)).contains(odd.get(3))) 
        return true;
      if(!mp.get(odd.get(0)).contains(odd.get(2)) && !mp.get(odd.get(1)).contains(odd.get(3))) 
        return true;
      if(!mp.get(odd.get(0)).contains(odd.get(3)) && !mp.get(odd.get(2)).contains(odd.get(1))) 
        return true;
      return false;
      
    }
}