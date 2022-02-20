class Solution {
    public List<String> letterCasePermutation(String str) {
        List<String> list = new LinkedList<>();
        call(list, str,0);
        return list;
    }
    public void call(List<String> list,String str, int i)
    {
        if(i==str.length())
        {
            list.add(str);
            return;
        }
        char ch = str.charAt(i);
        if(Character.isLetter(ch))
        {
           if(i==0)
           {
              String  str1=String.valueOf(Character.toLowerCase(ch))+str.substring(i+1);
              call(list,str1,i+1);
            str1=String.valueOf(Character.toUpperCase(ch))+str.substring(i+1);
               call(list,str1,i+1);
           }
            else if(i==str.length()-1)
            {
               String str1=str.substring(0,i)+String.valueOf(Character.toLowerCase(ch));
                call(list,str1,i+1);
                str1=str.substring(0,i)+String.valueOf(Character.toUpperCase(ch));
                call(list,str1,i+1);
            }
            else
               { 
               String  str1 = str.substring(0,i)+String.valueOf(Character.toLowerCase(ch))+str.substring(i+1);
                call(list,str1,i+1);
                str1 = str.substring(0,i)+String.valueOf(Character.toUpperCase(ch))+str.substring(i+1);
                call(list,str1,i+1);
               }
                
        }
        else
            call(list,str,i+1);
    }
}