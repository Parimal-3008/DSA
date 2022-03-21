class Solution {
    class Edge
    {
        int f;int l;
        public Edge(int f, int l)
        {
            this.f=f;
            this.l=l;
        }
    }
    public List<Integer> partitionLabels(String str) {
        
        Map<Character,Edge> mp = new LinkedHashMap<>();
        for(int i=0;i<str.length();i++)
        {
            char ch =str.charAt(i);
            if(!mp.containsKey(ch))
                mp.put(ch,new Edge(i,i));
            else
               mp.get(ch).l=i;
        }
        List<Integer> list = new LinkedList<>();
        
        int end=-1;int start=-1;
        for(Map.Entry<Character,Edge> entry:mp.entrySet())
        {
            char ch = entry.getKey();
            Edge e= entry.getValue();
            //System.out.println(ch+":"+e.f+","+e.l);
            if(start==-1&&end ==-1)
            {
                start = e.f; end=e.l;
            }
            else
            {
                if(e.f>end)
                {
                  //  System.out.println(ch+":"+end+"inside "+start);
                    list.add(end-start+1);
                     start = e.f; end=e.l;
                }
                else
                    end =Math.max(end,e.l);
            }
        }
         list.add(end-start+1);
        return list;
    }
}