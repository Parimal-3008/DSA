class Solution {
    public List<String> generateParenthesis(int n) {
       List<String> list = new LinkedList<>();
        call(list,n,0,0,"");
        return list;
        
    }
    public void call(List<String> list, int n, int o,int c,String curr)
    {
        if(curr.length()==2*n)
        {
            
                list.add(curr);
            return;
        }
        if(o<n)
            call(list,n,o+1,c,curr+"(");
        if(c<o)
            call(list,n,o,c+1,curr+")");
    }
   
}