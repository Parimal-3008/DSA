class AllOne {
  TreeMap<Integer,Set<String>> mp = new TreeMap<>();
  Map<String,Integer> mp2 = new HashMap<>();

    public AllOne() {
        mp = new TreeMap<>();
      mp.put(1,new TreeSet<>());
    }
    
    public void inc(String str) {
       
      if(mp2.containsKey(str))
      { 
        int  y = mp2.get(str);
        mp.get(y).remove(str); 
         if(mp.containsKey(y) && mp.get(y).isEmpty())
        mp.remove(y);
        if(!mp.containsKey(y+1))
          mp.put(y+1,new TreeSet<>());
        mp2.put(str,y+1);
       mp.get(y+1).add(str);
      }
      else
     {   
        mp2.put(str,1);
        if(!mp.containsKey(1))
          mp.put(1,new TreeSet<>());
       mp.get(1).add(str);
     
     }
      
     
        
    }
    
    public void dec(String str) {
      int  y = mp2.get(str);
      if(y==1)
      {
        mp.get(y).remove(str);
        mp2.remove(str);
      }
      else
      {
       mp.get(y).remove(str);
         if(!mp.containsKey(y-1))
          mp.put(y-1,new TreeSet<>());
        mp.get(y-1).add(str);
        mp2.put(str,y-1);
      }
      if(mp.get(y).isEmpty())
        mp.remove(y);
        
    }
    
    public String getMaxKey() {
      System.out.println(mp.get(mp.lastKey()));
        if(!mp.get(mp.lastKey()).isEmpty())
        {
          for(String str:mp.get(mp.lastKey()))
            return str;
        }
      return "";
    }
    
    public String getMinKey() {
      // System.out.println(mp);
         if(!mp.get(mp.firstKey()).isEmpty())
        {
          for(String str:mp.get(mp.firstKey()))
            return str;
        }
      return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */