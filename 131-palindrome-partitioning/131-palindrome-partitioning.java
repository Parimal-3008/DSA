class Solution {
    public List<List<String>> partition(String str) {
        List<List<String>> list = new ArrayList<>();
        call(str,0,list,new ArrayList<>());
        return list;
    }
    public void call(String str, int p,List<List<String>> list, List<String> temp)
    {
        if(p==str.length())
        {
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i=p;i<str.length();i++)
        {
            if(ispal(str.substring(p,i+1)))
            {
                 temp.add(str.substring(p,i+1));
                call(str,i+1,list,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean ispal(String str)
    {
        int l=0; int r=str.length()-1;
        while(l<r)
        {
            if(str.charAt(l)!=str.charAt(r))
                return false;
            l++;r--;
        }
        return true;
    }
}