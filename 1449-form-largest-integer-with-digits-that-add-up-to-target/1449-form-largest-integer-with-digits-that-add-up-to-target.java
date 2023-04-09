class Solution {
  class Node
  {
    boolean st;String str;
    public Node(boolean st, String str)
    {
      this.st = st;
      this.str=str;
    }
  }
    public String largestNumber(int[] arr, int k) {
      Map<Integer,Node> mp = new HashMap<>();
        Node p =  call(arr,k,mp);
      // for(int i=0;i<=k;i++)
      // {
      //   if(mp.containsKey(i))
      //     System.out.println(i+" "+mp.get(i).str);
      // }
       return p.st?p.str:"0";
    }
  public Node call(int[] arr, int k,Map<Integer,Node> dp)
  {
    if(k==0)
      return new Node(true,"");
    String max = "";
    if(dp.containsKey(k))
    {
      // System.out.println(k+" "+dp.get(k).str);
      return dp.get(k);
    }
    for(int i=0;i<9;i++)
    {
      Node temp =null;
      if(k-arr[i]>=0)
     {   
        Node temp2  =  call(arr,k-arr[i],dp);
        temp = new Node(temp2.st,temp2.str);
        temp.str+=String.valueOf(i+1);
        // System.out.println(temp.str);
      if(temp.st && temp.str.length()>max.length())
        max = temp.str;
      else if(temp.st && temp.str.length()== max.length() && max.compareTo(temp.str)<0)
        max = temp.str;
      }
    }
    if(max.equals(""))
    {
      dp.put(k,new Node(false,"0"));
      return dp.get(k);
    } 
    dp.put(k,new Node(true,max));
    return dp.get(k);
  }
  
}