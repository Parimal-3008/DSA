class Solution {
    public List<String> restoreIpAddresses(String str) {
      List<String> list = new ArrayList<>();
      call(str,0,0,list,"",0);
      return list;
        
    }
  public void call(String str,int i, int prev,List<String> list, String curr,int temp)
  {
    if(i== str.length())
    {
      if(prev<str.length())
      {
        String s1 = str.substring(prev);
       if(s1.charAt(0)=='0' && Long.parseLong(s1)==0 && temp==3 && (curr+"0").length()==str.length()+3)
          list.add(curr+"0");
       else if(s1.charAt(0)!='0' && Long.parseLong(s1)<=255 && temp ==3 && (curr+s1).length()==str.length()+3)
          list.add(curr+s1);       
      }     
        return;
    }
    if(temp>3)
      return;
    String s1 = str.substring(prev,i+1);
    if(s1.charAt(0)=='0' && Long.parseLong(s1)==0)
      call(str,i+1,i+1,list,curr+"0.",temp+1);
    else if(s1.charAt(0)!='0' && Long.parseLong(s1)<=255)
      call(str,i+1,i+1,list,curr+s1+".",temp+1);
    call(str,i+1,prev,list,curr,temp);
      
  }
}