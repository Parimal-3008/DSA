class Solution {
  class Edge
  {
    char ch;int freq;
    public Edge(char ch, int freq)
    {
      this.ch = ch;
      this.freq=freq;
    }
  }
  public class edgecom implements Comparator<Edge>
  {
    @Override
    public int compare(Edge e1, Edge e2)
    {
      return Integer.compare(e2.ch,e1.ch);
    }
  }
    public String repeatLimitedString(String str, int k2) {
      PriorityQueue<Edge> pq = new PriorityQueue<>(new edgecom());
      StringBuilder ans=new StringBuilder("");
      Map<Character,Edge> mp = new HashMap<>();
      for(int i=0;i<str.length();i++)
      {
        char t = str.charAt(i);
        if(mp.containsKey(t))
        {
          Edge p = mp.get(t);
          p.freq++;
          mp.put(t,p);
        }
        else
        {
          Edge p = new Edge(t,1);
          mp.put(t,p);
        }
      }
      for(char i='a';i<='z';i++)
      {
        if(mp.containsKey(i))
          pq.add(mp.get(i));
      }
      // System.out.println(mp);
      while(!pq.isEmpty())
      {
        Edge p = pq.poll();
        if(p.freq>=k2)
        {
          int o = p.freq;
          for(int i=0;i<k2;i++)
          {
            ans.append(String.valueOf(p.ch));
            p.freq--;
          }
          if(p.freq==0)
            continue;
          Edge p2 = pq.poll();
          if(p2==null)
            continue;
          ans.append(String.valueOf(p2.ch));
          p2.freq--;
          pq.add(p);
          if(p2.freq!=0)
          pq.add(p2);
        }
        else
        {
          int o = p.freq;
          for(int i=0;i<o;i++)
          {
            ans.append(String.valueOf(p.ch));
           p.freq--;
          }
        }
      }      
      return ans.toString();
    }
}