class Solution {
    String st[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String str) {
        List<String> list = new LinkedList<>();
        call(list,str,"",0);
        return list;
    }
    public void call(List<String> list,String str, String curr,int n)
    {
        if(n==str.length())
        {
            if(!curr.equals(""))
            list.add(curr);
            return;
        }
        char ch = str.charAt(n);
        int m= Integer.parseInt(String.valueOf(ch));
        for(int i=0;i<st[m].length();i++)
        {
            call(list,str,curr+String.valueOf(st[m].charAt(i)),n+1);
        }
    }
}