class Solution {
    public int evalRPN(String[] arr2) {
        List<Integer> list = new ArrayList<>();
      int p=0;
      for(String i:arr2)
      {
        if(!i.equals("+")&&!i.equals("-")&&!i.equals("*")&&!i.equals("/"))
        {
          list.add(Integer.parseInt(i));p++;
        }
        else
        {
          int a = list.get(p-1);
          list.remove(p-1);
          p--;
          
          int b = list.get(p-1);
           list.remove(p-1);
          p--;
          if(i.equals("+"))
            list.add(a+b);
          else if(i.equals("-"))
            list.add(b-a);
           else if(i.equals("*"))
            list.add(a*b);
           else if(i.equals("/"))
            list.add(b/a);
          p++;
        }
        // System.out.println(list);
      }
      
      return list.get(0);
    }
}