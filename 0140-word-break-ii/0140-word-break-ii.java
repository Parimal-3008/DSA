class Solution {
    public List<String> wordBreak(String s, List<String> dict) {
  Set<String> set = new HashSet<>();
        for(String i: dict)
            set.add(i);
       List<String> ans = new ArrayList<>();
        call(set,0,1,s,ans,new StringBuilder());
        return ans;
    }
    public void call(Set<String> set, int prev, int i, String str,List<String> ans,StringBuilder obj)
    {
        if(i==str.length())
        {
            String temp = str.substring(prev,i);
            if(set.contains(temp))
            {
                obj.append(" "+temp);
                ans.add(obj.toString().trim());
            }
            return;
            
                
        }
        
        call(set,prev,i+1,str,ans,new StringBuilder(obj.toString()));
        
        if(set.contains(str.substring(prev,i)))
        {
            StringBuilder obj2 = new StringBuilder(obj.toString()+" "+str.substring(prev,i));
            call(set,i,i+1,str,ans,obj2);;           
        }
       
    }
}