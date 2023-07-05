class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        call(n+n,0,list,"");
        return list;
    }
    public void call(int n, int curr, List<String> list, String str)
    {
        if(n==0)
        {
            if(curr==0)
                list.add(str);
            return;
        }
        call(n-1,curr+1,list,str+"(");
        if(curr-1>=0)
            call(n-1,curr-1,list,str+")");
    }
}